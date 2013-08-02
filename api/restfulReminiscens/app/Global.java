import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Locale;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import play.Application;
import play.GlobalSettings;
import play.data.format.Formatters;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Http.Request;
import play.mvc.Result;

public class Global extends GlobalSettings {
	// @SuppressWarnings("rawtypes")
	// @Override
	// public Action onRequest(Request request, Method actionMethod) {
	// String play_session = request.getHeader("PLAY_SESSION");
	// Logger.debug("play session header: " + play_session);
	// if(play_session != null && !"".trim().equals(play_session)){
	// scala.collection.immutable.Map<String, String> values =
	// Session.decode(play_session);
	// if(values.isEmpty()){
	// Logger.warn("ignoring a not valid session ! : " + play_session);
	// }else{
	// try {
	// //getting the request field from anon class
	// Field requestField = request.getClass().getDeclaredField("req$2");
	// play.api.mvc.Request requestInstance = (play.api.mvc.Request)
	// requestField.get(request);
	// // getting the session field
	// Field sessionField =
	// requestInstance.getClass().getDeclaredField("session");
	// sessionField.setAccessible(true);
	// Session sessionInstance = (Session) sessionField.get(requestInstance);
	// //getting the data from the session
	// Field dataField = sessionInstance.getClass().getDeclaredField("data");
	// dataField.setAccessible(true);
	// dataField.set(sessionInstance, Session.decode(play_session));
	// //everything was ok, so we'll add the cookie to the session because maybe
	// is going to be used later
	// // Field cookiesField =
	// requestInstance.getClass().getDeclaredField("cookies");
	// // cookiesField.setAccessible(true);
	// // cookiesField.set(requestInstance,
	// Session.encodeAsCookie(play_session));
	// Logger.debug("added to the session: " + sessionInstance);
	// } catch (SecurityException e) {
	// Logger.error(e.getMessage());
	// } catch (NoSuchFieldException e) {
	// Logger.error(e.getMessage());
	// }catch (IllegalAccessException e) {
	// Logger.error(e.getMessage());
	// }
	// }
	//
	// }
	// return super.onRequest(request, actionMethod);
	// }

	// /**
	// * Call to create the root Action of a request for a Java application.
	// * The request and actionMethod values are passed for information.
	// *
	// * @param request The HTTP Request
	// * @param actionMethod The action method containing the user code for this
	// Action.
	// * @return The default implementation returns a raw Action calling the
	// method.
	// */
	// @SuppressWarnings("rawtypes")
	// @Override
	// public Action onRequest(Request request, Method actionMethod) {
	// return new Action.Simple() {
	// public Result call(Context ctx) throws Throwable {
	// ctx.session().clear();
	// return delegate.call(ctx);
	// }
	// };
	// }

	// public void onStart(Application app) {
	// InitialData.insert(app);
	// }

	static class InitialData {

//		@SuppressWarnings("deprecation")
//		public static void insert(Application app) {
//
//			if (SecurityRole.find.findRowCount() == 0) {
//				for (final enums.Roles roleEnum : enums.Roles.values()) {
//					final SecurityRole role = new SecurityRole();
//					role.roleName = roleEnum.name();
//					role.save();
//				}
//			}
//
//			if (User.find.findRowCount() == 0) {

				// //adding a member
				// User user = new User();
				// user.setFname("First");
				// user.setSname("Member");
				// user.setEmail("first@example.com");
				// user.setActive(true);
				// user.setEmailValidated(true);
				// user.setRoles(Collections.singletonList(SecurityRole
				// .findByRoleName(Roles.MEMBER.toString())));
				// user.save();
				// MySignup signup = new MyUsernamePasswordAuthUser.
//				MyUsernamePasswordAuthUser auth = null;
//
//				auth = new MyUsernamePasswordAuthUser("First Member",
//						"member@member.com", "password");
//				User user = models.User.create(auth);
//				user.setEmailValidated(true);
//				user.update();
//
//				auth = new MyUsernamePasswordAuthUser("Second Member",
//						"member2@member.com", "password");
//				user = models.User.create(auth);
//				user.setEmailValidated(true);
//				user.update();
//
//				auth = new MyUsernamePasswordAuthUser("First Owner",
//						"owner@owner.com", "password");
//				user = models.User.create(auth);
//				user.resetSecurityRole(SecurityRole.findByRoleName(Roles.OWNER
//						.toString()));
//				user.setEmailValidated(true);
//				user.update();
//
//				auth = new MyUsernamePasswordAuthUser("Second Owner",
//						"owner2@owner.com", "password");
//				user = models.User.create(auth);
//				user.resetSecurityRole(SecurityRole.findByRoleName(Roles.OWNER
//						.toString()));
//				user.setEmailValidated(true);
//				user.update();
//
//				auth = new MyUsernamePasswordAuthUser("First Trainer",
//						"trainer@trainer.com", "password");
//				user = models.User.create(auth);
//				user.resetSecurityRole(SecurityRole
//						.findByRoleName(Roles.TRAINER.toString()));
//				user.setEmailValidated(true);
//				user.update();

				// //adding a owner
				// user = new User();
				// user.setFname("Second");
				// user.setSname("Owner");
				// user.setEmail("second@example.com");
				// user.setActive(true);
				// user.setEmailValidated(true);
				// user.setRoles(Collections.singletonList(SecurityRole
				// .findByRoleName(Roles.OWNER.toString())));
				// user.save();
				//
				// //adding a trainer
				// user = new User();
				// user.setFname("Third");
				// user.setSname("Trainer");
				// user.setEmail("third@example.com");
				// user.setActive(true);
				// user.setEmailValidated(true);
				// user.setRoles(Collections.singletonList(SecurityRole
				// .findByRoleName(Roles.TRAINER.toString())));
				// user.save();

			}

			// if (Ebean.find(User.class).findRowCount() == 0) {
			//
			// // Map<String,List<Object>> all =
			// // (Map<String,List<Object>>)Yaml.load("initial-data.yml");
			// Map<String, List<Object>> all = (Map<String, List<Object>>) Yaml
			// .load("initial-data-social-gym.yml");
			//
			// // Insert users first
			// Ebean.save(all.get("users"));
			// // Ebean.save(all.get("activities"));
			// // Ebean.save(all.get("levels"));
			// // // Insert projects
			// // Ebean.save(all.get("projects"));
			// // for(Object project: all.get("projects")) {
			// // // Insert the project/user relation
			// // Ebean.saveManyToManyAssociations(project, "members");
			// // }
			// //
			// // // Insert tasks
			// // Ebean.save(all.get("tasks"));
			// //
			// }
//		}
//
//	}

	public void onStart(final Application app) {

//		InitialData.insert(app);
//
//		PlayAuthenticate.setResolver(new Resolver() {
//			@Override
//			public Call login() {
//				// Your login page
//				return routes.Application.index();
//			}
//
//			@Override
//			public Call afterAuth() {
//				// The user will be redirected to this page after authentication
//				// if no original URL was saved
//
//				// play.mvc.Call call = new Call() {
//				// @Override
//				// public String url() {
//				// final play.mvc.Http.Cookie cookie = play.mvc.Http.Context
//				// .current().request().cookie("PLAY_SESSION");
//				// String url_decoded = "";
//				// try {
//				// url_decoded = java.net.URLDecoder.decode(
//				// controllers.routes.Application.id(
//				// "!#" + cookie.name() + "="
//				// + cookie.value()).url(),
//				// "UTF-8");
//				// } catch (UnsupportedEncodingException e) {
//				// e.printStackTrace();
//				// }
//				// return url_decoded;
//				// }
//				//
//				// @Override
//				// public String method() {
//				// return "GET";
//				// }
//				// };
//				// return call;
//				return routes.Restricted.index();
//			}
//
//			@Override
//			public Call afterLogout() {
//				// TODO what should we do ?
//				return routes.Application.index();
//			}
//
//			@Override
//			public Call auth(final String provider) {
//				// You can provide your own authentication implementation,
//				// however the default should be sufficient for most cases
//				// return
//				// com.feth.play.module.pa.controllers.routes.Authenticate
//				// .authenticate(provider);
//				return controllers.routes.AuthenticateLocal
//						.authenticate(provider);
//			}
//
//			@Override
//			public Call onException(final AuthException e) {
//				if (e instanceof AccessDeniedException) {
//					return routes.Application
//							.oAuthDenied(((AccessDeniedException) e)
//									.getProviderKey());
//				}
//
//				// more custom problem handling here...
//
//				return super.onException(e);
//			}
//
//			@Override
//			public Call askLink() {
//				// We don't support moderated account linking in this sample.
//				// See the play-authenticate-usage project for an example
//				return null;
//			}
//
//			@Override
//			public Call askMerge() {
//				// We don't support moderated account merging in this sample.
//				// See the play-authenticate-usage project for an example
//				return null;
//			}
//		});

		Formatters
				.register(
						DateTime.class,
						new Formatters.AnnotationFormatter<utils.JodaDateTime, DateTime>() {
							@Override
							public DateTime parse(
									utils.JodaDateTime annotation,
									String input, Locale locale)
									throws ParseException {
								if (input == null || input.trim().isEmpty())
									return null;

								if (annotation.format().isEmpty())
									return new DateTime(Long.parseLong(input));
								else
									return DateTimeFormat
											.forPattern(annotation.format())
											.withLocale(locale)
											.parseDateTime(input);
							}

							@Override
							public String print(utils.JodaDateTime annotation,
									DateTime time, Locale locale) {
								if (time == null)
									return null;

								if (annotation.format().isEmpty())
									return time.getMillis() + "";
								else
									return time.toString(annotation.format(),
											locale);
							}

						});
	}

	/**
	 * Call to create the root Action of a request for a Java application. The
	 * request and actionMethod values are passed for information.
	 * 
	 * @param request
	 *            The HTTP Request
	 * @param actionMethod
	 *            The action method containing the user code for this Action.
	 * @return The default implementation returns a raw Action calling the
	 *         method.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Action onRequest(Request request, Method actionMethod) {
		return new Action.Simple() {
			public Result call(Context ctx) throws Throwable {
				Result r = delegate.call(ctx);
				ctx.session().clear();
				//
				// String context =
				// Configuration.root().getString("application.context");
				// ctx.response().discardCookie("PLAY_SESSION");
				// ctx.response().discardCookie("PLAY_SESSION", context);
				return r;
			}
		};
	}

}