package com.crud.tasks.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestController
@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public final void handleNullPointerException() {
        System.out.println("There is no task with such ID");

    }
}