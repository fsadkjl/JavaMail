package com.wjl.test;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;


public class QQEmail{
	public static void main(String[] args) throws MessagingException, GeneralSecurityException {
	    Properties props = new Properties();
	 
	    // 开启debug调试
	    props.setProperty("mail.debug", "true");
	    // 发送服务器需要身份验证
	    props.setProperty("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", 465);// 端口号
	    // 设置邮件服务器主机名
	    props.setProperty("mail.smtp.host", "smtp.qq.com");
	    // 发送邮件协议名称
	    props.setProperty("mail.transport.protocol", "smtp");
	 
	    MailSSLSocketFactory sf = new MailSSLSocketFactory();
	    sf.setTrustAllHosts(true);
	    props.put("mail.smtp.ssl.enable", "true");
	    props.put("mail.smtp.ssl.socketFactory", sf);
	 
	    Session session = Session.getInstance(props);
	 
	    Message msg = new MimeMessage(session);
	    msg.setSubject("123");
	    StringBuilder builder = new StringBuilder();
	    builder.append("456");
	    msg.setText(builder.toString());
	    msg.setFrom(new InternetAddress("1391045868@qq.com"));
	 
	    Transport transport = session.getTransport();
	    transport.connect("smtp.qq.com", "1391045868@qq.com", "exevboowrxvlbagg");
	 
	    transport.sendMessage(msg, new Address[] { new InternetAddress("904822026@qq.com") });
	    transport.close();
	  }

	
}

