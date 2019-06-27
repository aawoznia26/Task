package com.crud.tasks.domain;

public class Mail {

    private String receiverEmail;
    private String subject;
    private String message;
    private String toCc;

    public Mail(String receiverEmail, String subject, String message, String toCc) {
        this.receiverEmail = receiverEmail;
        this.subject = subject;
        this.message = message;
        this.toCc = toCc;
    }

    public Mail(String receiverEmail, String subject, String message) {
        this.receiverEmail = receiverEmail;
        this.subject = subject;
        this.message = message;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getToCc() {
        return toCc;
    }
}
