package com.example.javazoo.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;


@Entity
@Table(name = "emails")
public class EmailList {

    @Id
    @GeneratedValue
    private long emailid;

    @Column(nullable = false, unique = true)

    private String emailaddress;

    public EmailList() {
    }

    public EmailList(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public long getEmailid() {
        return emailid;
    }

    public void setEmailid(long emailid) {
        this.emailid = emailid;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }
}
