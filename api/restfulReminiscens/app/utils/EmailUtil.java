package utils;

//import pojos.MemberShipBean;

//import com.typesafe.plugin.MailerAPI;
//import com.typesafe.plugin.MailerPlugin;


public class EmailUtil {

//	public void sendMembershipInvitationEmail(MemberShipBean membership, String key) {
//		MailerAPI mail = play.Play.application().plugin(MailerPlugin.class)
//				.email();
//		mail.setSubject(membership.getUser().getFname()
//				+ " you have been invited to be part of "
//				+ membership.getClub().getName());
//		mail.addFrom("Social Gym <lifaparticipation@google.com>");
//		mail.addRecipient(membership.getUser().getFname() + " "
//				+ membership.getUser().getSname() + " <"
//				+ membership.getUser().getEmail() + ">");
//		// mail.addFrom("Peter Hausel <noreply@email.com>");
//		// sends html
//		String server = play.Play.application().configuration().getString("serverUrl");
////		mail.sendHtml("<html><a href=" + server+ "/request/"+ key + "></a></html>" );
//		mail.send(server+ "/request/"+ key);
//		// sends text/text
//		// mail.send( "text" );
//		// sends both text and html
////		String body = views.emails.html.ipackage.html..memApemhtml.helper.mailBody.render(membership).body();
////		mail.send("text", "<html>html</html>");
//	}

	// public static void welcome(UserBean user) {
	// setSubject("Welcome %s", user.name);
	// addRecipient(user.getEmail());
	// addFrom("Me <me@me.com>");
	// // EmailAttachment attachment = new EmailAttachment();
	// // attachment.setDescription("A pdf document");
	// // attachment.setPath(Play.getFile("rules.pdf").getPath());
	// // addAttachment(attachment);
	// send(user);
	// }
	//
	// public static void lostPassword(UserBean user) {
	// String newpassword = user.password;
	// addFrom("Robot <robot@thecompany.com>");
	// setSubject("Your password has been reset");
	// addRecipient(user.email);
	// send(user, newpassword);
	// }

}
