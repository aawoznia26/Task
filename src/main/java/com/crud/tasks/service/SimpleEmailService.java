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
import org.springframework.stereotype.Service;

@Service
public class SimpleEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    public void send(final Mail mail){

        LOGGER.info("Starting email preparation");

        try{
            SimpleMailMessage simpleMailMessage = createMailMessage(mail);
            javaMailSender.send(simpleMailMessage);

            LOGGER.info("Email has been sent");

        }catch(MailException e){
            LOGGER.error("Failed to process email sending", e.getMessage(), e);
        }catch(ValidatorException u){
            LOGGER.error("Failed to process email sending", u.getMessage(), u);
        }

    }

    private SimpleMailMessage createMailMessage(Mail mail) throws ValidatorException{

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        if (EmailValidator.getInstance().isValid(mail.getReceiverEmail())) {
            simpleMailMessage.setTo(mail.getReceiverEmail());
            LOGGER.info("Receiver email is valid");
            simpleMailMessage.setSubject(mail.getSubject());
            simpleMailMessage.setText(mail.getMessage());

            if(EmailValidator.getInstance().isValid(mail.getToCc())){
                simpleMailMessage.setCc(mail.getToCc());
                LOGGER.info("ToCC email is valid");
            } else {
                LOGGER.error("ToCC email is not valid");
            }
        } else {
            LOGGER.error("Receiver email is not valid");
            throw new ValidatorException("Receiver email is not valid");
        }
        return simpleMailMessage;
    }
}
