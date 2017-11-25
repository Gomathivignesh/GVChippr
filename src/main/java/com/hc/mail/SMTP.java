package com.hc.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SMTP implements Runnable{

	public static final String SENT_FROM = "101years1@gmail.com";
	public static final String SMTP_AMAZON_SES_USERNAME = "AKIAJDMEKG4RLS3IGYYA";
	public static final String SMTP_AMAZON_SES_PASSWORD = "AlfCrIyB9HHM2ER2PFw1/J/LdRTMnm0OMnKk8ltGQfwi";
	private String toEmail;
	private String subject;
	private String body;
	
	public SMTP(String toEmail, String subject, String body){
		this.toEmail = toEmail;
		this.subject = subject;
		this.body = body;
	}
	
	public void run(){
		sendMail(this.toEmail, this.subject, this.body);
	}
    
	public static void sendMail(String toEmail, String subject, String body){
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "email-smtp.us-west-2.amazonaws.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props, new javax.mail.Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication(){
					return new PasswordAuthentication(SMTP_AMAZON_SES_USERNAME, SMTP_AMAZON_SES_PASSWORD);
				}
		});
 
		try { 
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(SENT_FROM));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject(subject);
			message.setText(body,"utf-8", "html"); 
			Transport.send(message); 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
