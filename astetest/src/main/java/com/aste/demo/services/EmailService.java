package com.aste.demo.services;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.aste.demo.models.Email;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMail(Email email) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo("softwarealamdar@gmail.com");
			helper.setSubject(email.getSubject());
			helper.setText("<html><body>"
			        + email.getMessage() + "<br/>"
			        + "<h2>"+email.getName() +"</h2>"
			        +"<br/>"+" This message is sent by " 
			        + email.getEmail()
			        +"</body></html>", true);
			javaMailSender.send(message);
			autoResponse(email);
			
		} catch (Exception e) {
			e.printStackTrace();		}
	}
	
	public void autoResponse(Email email) {
		try {
			MimeMessage message1 = javaMailSender.createMimeMessage();
			MimeMessageHelper helper1 = new MimeMessageHelper(message1);
			helper1.setFrom("softwarealamdar@gmail.com");
			helper1.setText("<html><body>"+"Thankyou for your interest in ASTE."+"<br/>"+"This is an auto generated response."+"<br/>"+"Please do not reply back"+"<html><body>",true);
			helper1.setSubject("Computer generated autoresponse");
			helper1.setTo(email.getEmail());
			javaMailSender.send(message1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
