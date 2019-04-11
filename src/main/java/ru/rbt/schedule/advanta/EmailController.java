package ru.rbt.schedule.advanta;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.mail.*;
import javax.mail.internet.*;

import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by BritikovMI on 11.04.2019.
 */
@RestController
public class EmailController {
    private static final String username = "tastytest549@gmail.com";
    private static final String password = "tastytest549tastytest549";
    private final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

    @RequestMapping("/s")
    public String sendEmail() {
        String recepient = "supercep110@gmail.com";
        String month = "Апреля";
        String content = "Test";
        try {
            sendmail(recepient, month, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Email sent successfully";
    }

    private void sendmail(String recepient, String month, String content) throws Exception {
        month = month.replace("ря", "рь").replace("ля", "ль").replace("та", "т").replace("ня", "нь");
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
//        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepient));
        msg.setSubject("тш " + month);
        msg.setContent(content, "text/html");
        msg.setSentDate(new Date());

        Transport.send(msg);

    }
}