package com.ttnd.reap.MailAPI;

//this will work only for gmail.

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.ttnd.reap.pojo.EmployeeDetails;

public class SendEmail {
	public static void sendMail(List<EmployeeDetails> emplDetails) {

		Address[] to = new Address[emplDetails.size()];

		try {
			for (int i = 0; i < to.length; i++) {
				to[i] = new InternetAddress(emplDetails.get(i).getEmail());
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		// Recipient's email ID needs to be mentioned.
		String tom = "ankur@tothenew.com";// address of recipient

		// Sender's email ID needs to be mentioned
		String from = "pratishtha.sharma20@gmail.com"; // address of sender

		// Assuming you are sending email from localhost
		String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		// properties.setProperty("mail.smtp.host", host);

		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.user", "emailID"); // User name
		properties.put("mail.smtp.password", "password"); // password
		properties.put("mail.smtp.port", "587");// default mail submission port
		properties.put("mail.smtp.auth", "true");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("emailID", "password"); // user
																			// name
																			// will
																			// be
																			// ur
																			// email
																			// address
																			// and
																			// password
																			// same
																			// as
																			// of
																			// ur
																			// gamil
																			// account.
																			// and
																			// if
																			// ur
																			// account
																			// is
																			// protected
																			// with
																			// 2
																			// step
																			// verification
																			// then
																			// u
																			// need
																			// to
																			// generate
																			// app
																			// password
																			// form
																			// the
																			// link
																			// provied
																			// https://security.google.com/settings/security/apppasswords
			}
		});

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			//message.addRecipient(Message.RecipientType.TO, new InternetAddress(tom));

			//Send Email to multiple recipients
			message.addRecipients(Message.RecipientType.TO, to);
			
			// Set Subject: header field
			message.setSubject("Subject text via Java Class");

			// Now set the actual message
			message.setText("Message Content should be written here!!! Regards: Pratishtha Sharma ");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mEx) {
			mEx.printStackTrace();
		}
	}
}