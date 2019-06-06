package com.example.project.Business;

import com.example.project.Persistence.Entity.Client;
import com.example.project.Persistence.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {
    private JavaMailSender javaMailSender;

    /**
     *
     * @param javaMailSender
     */
    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * This fucntion is used to send mail that contains a attachment.
     *
     * @throws MailException
     * @throws MessagingException
     */
    public void sendEmailWithAttachment(User client) throws MailException, MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(client.getEmailAddress());
        helper.setSubject("Your Theatre Ticket is Here !");
        helper.setText("Please find the attached document below, containing the tickets for your favorite play. Enjoy !");

        ClassPathResource classPathResource = new ClassPathResource("templates/ticket_view.html");
        helper.addAttachment(classPathResource.getFilename(), classPathResource);

        javaMailSender.send(mimeMessage);
    }
}
