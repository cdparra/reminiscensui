package providers;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import play.Application;
import play.Configuration;
import play.Logger;
import play.libs.WS;
import play.libs.WS.Response;
import play.mvc.Http.Context;
import play.mvc.Http.Request;

import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.controllers.Authenticate;
import com.feth.play.module.pa.exceptions.AccessDeniedException;
import com.feth.play.module.pa.exceptions.AccessTokenException;
import com.feth.play.module.pa.exceptions.AuthException;
import com.feth.play.module.pa.exceptions.RedirectUriMismatch;
import com.feth.play.module.pa.providers.oauth2.OAuth2AuthProvider;
import com.feth.play.module.pa.providers.oauth2.google.GoogleAuthInfo;
import com.feth.play.module.pa.providers.oauth2.google.GoogleAuthProvider;
import com.feth.play.module.pa.providers.oauth2.google.GoogleAuthUser;

public class GoogleLocalAuthProvider extends GoogleAuthProvider{
	
	public static final String TOKEN_INFORMATION_URL = "tokenInformationUrl";

	public GoogleLocalAuthProvider(Application app) {
		super(app);
	}
	
	@Override
	public Object authenticate(final Context context, final Object payload)
			throws AuthException {

		final Request request = context.request();

		if (Logger.isDebugEnabled()) {
			Logger.debug("Returned with URL: '" + request.uri() + "'");
		}

		final String error = Authenticate.getQueryString(request,
				Constants.ERROR);
		final String code = Authenticate
				.getQueryString(request, Constants.CODE);
		
		final String access_token = Authenticate
				.getQueryString(request, Constants.ACCESS_TOKEN);

		// Attention: facebook does *not* support state that is non-ASCII - not
		// even encoded.
		final String state = Authenticate.getQueryString(request,
				Constants.STATE);

		if (error != null) {
			if (error.equals(Constants.ACCESS_DENIED)) {
				throw new AccessDeniedException(getKey());
			} else if (error.equals(Constants.REDIRECT_URI_MISMATCH)) {
				Logger.error("You must set the redirect URI for your provider to whatever you defined in your routes file."
						+ "For this provider it is: '"
						+ getRedirectUrl(request) + "'");
				throw new RedirectUriMismatch();
			} else {
				throw new AuthException(error);
			}
		}else if (code != null) {
			// second step in auth process
			final GoogleAuthInfo info = getAccessToken(code, request);

			final GoogleAuthUser u = transform(info, state);
			return u;
			// System.out.println(accessToken.getAccessToken());
		} else if (access_token != null) {
			// accessing using google token
			final GoogleAuthInfo info = confirmAccessToken(access_token, request);
			
//			final GoogleAuthInfo info = new GoogleAuthInfo(node)
			final GoogleAuthUser u = transform(info, state);
			return u;
			// System.out.println(accessToken.getAccessToken());
		} else {
			// no auth, yet
			final String url = getAuthUrl(request, state);
			Logger.debug("generated redirect URL for dialog: " + url);
			return url;
		}
	}
	
	private GoogleAuthInfo confirmAccessToken(final String token, final Request request)
			throws AccessTokenException {
		final Configuration c = getConfiguration();
		final String params = getAccessTokenParams(token, request);
		final String url = c.getString(TOKEN_INFORMATION_URL);
		final Response r = WS.url(url)
				.setHeader("Content-Type", "application/x-www-form-urlencoded")
				.post(params).get(PlayAuthenticate.TIMEOUT);
		return buildInfo(r, token);
	} 
	
	private String getAccessTokenParams(final String token, Request request) {
		final List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(Constants.ACCESS_TOKEN, token));
		return URLEncodedUtils.format(params, "UTF-8");
	}
	
	protected GoogleAuthInfo buildInfo(final Response r, final String token)
			throws AccessTokenException {
		final JsonNode n = r.asJson();
		ObjectNode jNode = (ObjectNode) n;
		jNode.put(Constants.ACCESS_TOKEN, token);
		jNode.put(Constants.TOKEN_TYPE, "Bearer");
		jNode.put("id_token", "");
		
		Logger.debug(jNode.toString());

		if (n.get(OAuth2AuthProvider.Constants.ERROR) != null) {
			throw new AccessTokenException(n.get(
					OAuth2AuthProvider.Constants.ERROR).asText());
		} else {
			return new GoogleAuthInfo(jNode);
		}
	}
	
}
