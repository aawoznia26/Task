package com.crud.tasks.trello.config;


import lombok.Getter;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AdminConfig {

    @Value("${admin.mail}")
    private String adminMail;

    @Value("${info.app.owner.name}")
    private String adminName;

    @Value("${info.company.name}")
    private String companyName;

    @Value("${info.company.email}")
    private String companyEmail;

    @Value("${info.company.phone}")
    private String companyPhone;
}
