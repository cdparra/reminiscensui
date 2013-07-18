package service;

import static play.libs.Json.toJson;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.NotImplementedException;

import play.Logger;
import play.api.libs.Crypto;
import play.i18n.Messages;
import play.mvc.Call;
import play.mvc.Controller;
import play.mvc.Http.Context;
import play.mvc.Http.Session;
import play.mvc.Result;

import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.exceptions.AuthException;
import com.feth.play.module.pa.providers.AuthProvider;
import com.feth.play.module.pa.user.AuthUser;

import controllers.routes;

public class PlayAuthenticateLocal extends PlayAuthenticate {

	private static final String SETTING_KEY_ACCOUNT_AUTO_LINK = "accountAutoLink";
	private static final String SETTING_KEY_ACCOUNT_AUTO_MERGE = "accountAutoMerge";

	// public static Result loginAndRedirect(final Context context,
	// final AuthUser loginUser) {
	//
	// // storeUser(context.session(), loginUser);
	// String encoded = "";
	// String signed = "";
	// try {
	// StringBuffer sb = new StringBuffer();
	// sb.append("pa.u.exp:");
	// sb.append(context.session().get("pa.u.exp"));
	// sb.append("\u0000pa.p.id:");
	// sb.append(context.session().get("pa.p.id"));
	// sb.append("\u0000pa.u.id:");
	// sb.append(context.session().get("pa.u.id"));
	// encoded = java.net.URLEncoder.encode(sb.toString(), "UTF-8");
	// signed = Crypto.sign(encoded);
	// } catch (UnsupportedEncodingException e) {
	// Logger.error(e.getMessage());
	// e.printStackTrace();
	// }
	// if(Logger.isDebugEnabled()){
	// Logger.debug("session generated: " + "PLAY_SESSION=" + signed + "-" +
	// encoded);
	// }
	// return Controller.ok(toJson("PLAY_SESSION=" + signed + "-" + encoded));
	// }

	public static Result loginAndRedirect(final Context context,
			final AuthUser loginUser) {

		String encoded = "";
		String signed = "";
		try {
			StringBuffer sb = new StringBuffer();
			if (loginUser.expires() != AuthUser.NO_EXPIRATION) {
				sb.append("pa.u.exp:");
				sb.append(loginUser.expires());
				sb.append("\u0000");
			}
			sb.append("pa.p.id:");
			sb.append(loginUser.getProvider());
			sb.append("\u0000pa.u.id:");
			sb.append(loginUser.getId());
			encoded = java.net.URLEncoder.encode(sb.toString(), "UTF-8");
			signed = Crypto.sign(encoded);
		} catch (UnsupportedEncodingException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
		if (Logger.isDebugEnabled()) {
			Logger.debug("session generated: " + "PLAY_SESSION=" + signed + "-"
					+ encoded);
		}
		return Controller.ok(toJson("PLAY_SESSION=" + signed + "-" + encoded));
	}

	public static Result handleAuthentication(final String provider,
			final Context context, final Object payload) {
		final AuthProvider ap = getProvider(provider);
		if (ap == null) {
			// Provider wasn't found and/or user was fooling with our stuff -
			// tell him off:
			// return Controller.notFound(Messages.get(
			// "playauthenticate.core.exception.provider_not_found",
			// provider));
			return Controller.badRequest(Messages.get(
					"playauthenticate.core.exception.provider_not_found",
					provider));
		}
		try {
			final Object o = ap.authenticate(context, payload);
			if (o instanceof String) {
				if ("NOT_FOUND".equals(o)) {
					return Controller
							.notFound(Messages
									.get("playauthenticate.password.login.unknown_user_or_pw"));
				} else if(routes.Signup.unverified().url().equals(o)){
					return Controller
							.ok(Messages
									.get("playauthenticate.verify.email.cta"));
				}else
				// TODO change this avoiding redirect
				// return Controller.redirect((String) o);
				throw new NotImplementedException(
						"not implemented when the authenticate response: " + o);
			} else if (o instanceof AuthUser) {

				final AuthUser newUser = (AuthUser) o;
				final Session session = context.session();

				// We might want to do merging here:
				// Adapted from:
				// http://stackoverflow.com/questions/6666267/architecture-for-merging-multiple-user-accounts-together
				// 1. The account is linked to a local account and no session
				// cookie is present --> Login
				// 2. The account is linked to a local account and a session
				// cookie is present --> Merge
				// 3. The account is not linked to a local account and no
				// session cookie is present --> Signup
				// 4. The account is not linked to a local account and a session
				// cookie is present --> Linking Additional account

				// get the user with which we are logged in - is null if we
				// are
				// not logged in (does NOT check expiration)

				AuthUser oldUser = getUser(session);

				// checks if the user is logged in (also checks the expiration!)
				boolean isLoggedIn = isLoggedIn(session);

				Object oldIdentity = null;

				// check if local user still exists - it might have been
				// deactivated/deleted,
				// so this is a signup, not a link
				if (isLoggedIn) {
					oldIdentity = getUserService().getLocalIdentity(oldUser);
					isLoggedIn &= oldIdentity != null;
					if (!isLoggedIn) {
						// if isLoggedIn is false here, then the local user has
						// been deleted/deactivated
						// so kill the session
						logout(session);
						oldUser = null;
					}
				}

				final Object loginIdentity = getUserService().getLocalIdentity(
						newUser);
				final boolean isLinked = loginIdentity != null;

				final AuthUser loginUser;
				if (isLinked && !isLoggedIn) {
					// 1. -> Login
					loginUser = newUser;

				} else if (isLinked && isLoggedIn) {
					// 2. -> Merge

					// merge the two identities and return the AuthUser we want
					// to use for the log in
					if (isAccountMergeEnabled()
							&& !loginIdentity.equals(oldIdentity)) {
						// account merge is enabled
						// and
						// The currently logged in user and the one to log in
						// are not the same, so shall we merge?

						if (isAccountAutoMerge()) {
							// Account auto merging is enabled
							loginUser = getUserService()
									.merge(newUser, oldUser);
						} else {
							// Account auto merging is disabled - forward user
							// to merge request page
							final Call c = getResolver().askMerge();
							if (c == null) {
								throw new RuntimeException(
										Messages.get(
												"playauthenticate.core.exception.merge.controller_undefined",
												SETTING_KEY_ACCOUNT_AUTO_MERGE));
							}
							storeMergeUser(newUser, session);
							// TODO solve this avoiding redirect
							return Controller.redirect(c);
						}
					} else {
						// the currently logged in user and the new login belong
						// to the same local user,
						// or Account merge is disabled, so just change the log
						// in to the new user
						loginUser = newUser;
					}

				} else if (!isLinked && !isLoggedIn) {
					// 3. -> Signup
					loginUser = signupUser(newUser);
				} else {
					// !isLinked && isLoggedIn:

					// 4. -> Link additional
					if (isAccountAutoLink()) {
						// Account auto linking is enabled

						loginUser = getUserService().link(oldUser, newUser);
					} else {
						// Account auto linking is disabled - forward user to
						// link suggestion page
						final Call c = getResolver().askLink();
						if (c == null) {
							throw new RuntimeException(
									Messages.get(
											"playauthenticate.core.exception.link.controller_undefined",
											SETTING_KEY_ACCOUNT_AUTO_LINK));
						}
						storeLinkUser(newUser, session);
						// TODO change this avoiding redirect
						return Controller.redirect(c);
					}

				}

				return loginAndRedirect(context, loginUser);
			} else {
				return Controller.internalServerError(Messages
						.get("playauthenticate.core.exception.general"));
			}
		} catch (final AuthException e) {
			final Call c = getResolver().onException(e);
			if (c != null) {
				// TODO Solve avoiding redirects
				return Controller.redirect(c);
			} else {
				final String message = e.getMessage();
				if (message != null) {
					return Controller.internalServerError(message);
				} else {
					return Controller.internalServerError();
				}
			}
		}
	}

	private static AuthUser signupUser(final AuthUser u) throws AuthException {
		final AuthUser loginUser;
		final Object id = getUserService().save(u);
		if (id == null) {
			throw new AuthException(
					Messages.get("playauthenticate.core.exception.singupuser_failed"));
		}
		loginUser = u;
		return loginUser;
	}

}
