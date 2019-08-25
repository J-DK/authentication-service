package com.auth.login.model;

import org.springframework.stereotype.Component;

@Component
public class User {

    private String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
