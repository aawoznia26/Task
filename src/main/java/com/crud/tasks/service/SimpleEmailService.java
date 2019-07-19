package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.apache.commons.validator.ValidatorException;
import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class SimpleEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailCreatorService mailCreatorService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    public void send(final Mail mail){

        LOGGER.info("Starting email preparation");

        try{

            javaMailSender.send(createMimeMessage(mail));

            LOGGER.info("Email has been sent");

        }catch(MailException e){
            LOGGER.error("Failed to process email sending", e.getMessage(), e);
        }

    }

    private MimeMessagePreparator createMimeMessage(final Mail mail){
        return mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(mail.getReceiverEmail());
            messageHelper.setSubject(mail.getSubject());
            if(mail.getSubject().contains("day")){
                messageHelper.setText(mailCreatorService.buildNumberOfTasksEmail(mail.getMessage()), true);
            }else{
                messageHelper.setText(mailCreatorService.buildTrelloCardEmail(mail.getMessage()), true);
            }

        };
    }

    private SimpleMailMessage createMailMessage(final Mail mail){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mail.getReceiverEmail());
        simpleMailMessage.setSubject(mail.getSubject());
        if(mail.getSubject().contains("day")){
            simpleMailMessage.setText(mailCreatorService.buildNumberOfTasksEmail(mail.getMessage()));
        }else{
            simpleMailMessage.setText(mailCreatorService.buildTrelloCardEmail(mail.getMessage()));
        }


        return simpleMailMessage;
    }
}
