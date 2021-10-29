package com.emrebaglayici.myapplication.model;

public class Model {

    public String companyName;
    public String subject;
    public String message;

    public Model(String sendTo, String subject, String message) {
        this.companyName = sendTo;
        this.subject = subject;
        this.message = message;
    }
}
