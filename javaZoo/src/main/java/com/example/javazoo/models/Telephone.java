package com.example.javazoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "telephones")
public class Telephone extends Auditable{

    @Id
    @GeneratedValue
    private long phoneid;

    @Column(nullable = false)
    private String phonetype;

    @Column(nullable = false, unique = true)
    private String phonenumber;

    @ManyToOne
    @JoinColumn(name = "zooid",
    nullable = false
    )
    @JsonIgnoreProperties(value = "telephones")
    private Zoo zoo;

    public Telephone() {
    }

    public Telephone(long phoneid, String phonetype, String phonenumber, Zoo zoo) {
        this.phoneid = phoneid;
        this.phonetype = phonetype;
        this.phonenumber = phonenumber;
        this.zoo = zoo;
    }

    public long getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(long phoneid) {
        this.phoneid = phoneid;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }
}
