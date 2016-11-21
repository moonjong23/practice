package com.pack.controller;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(Email email)throws Exception{
		MimeMessage msg = mailSender.createMimeMessage();//메일 발송 기능 & file 첨부 기능
		msg.setSubject(email.getSubject()); //메일 제목
		msg.setText(email.getContent()); //메일 내용
		msg.setRecipient(RecipientType.TO, new InternetAddress(email.getReceiver()));
		mailSender.send(msg);
		
	}
}
