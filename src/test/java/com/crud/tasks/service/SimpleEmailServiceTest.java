package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SimpleEmailServiceTest {

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;


    @Test
    public void shouldSentMail(){

        //Given
        Mail mail = new Mail("test@test.com", "Test", "Test message", "test@test.pl");


        //When
        simpleEmailService.send(mail);

        //Then
        verify(javaMailSender, times(1)).send(any(MimeMessagePreparator.class));

    }

    @Test
    public void shouldSentMailWithoutCC() {

        //Given
        Mail mail = new Mail("test@test.com", "Test", "Test message");

        //When
        simpleEmailService.send(mail);

        //Then
        verify(javaMailSender, times(1)).send(any(MimeMessagePreparator.class));


    }
}