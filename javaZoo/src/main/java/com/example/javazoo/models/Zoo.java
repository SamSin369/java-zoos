package com.example.javazoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="zoos")
public class Zoo extends Auditable{

    @Id
    @GeneratedValue
    private long zooid;

    @Column(nullable = false, unique = true)
    private String zooname;

    @OneToMany(mappedBy = "zoo",
    cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties(value = "zoo")
    private Set<Telephone> telephones = new HashSet<>();
    @OneToMany(mappedBy = "zoo",
    cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties(value = "zoo", allowSetters = true)
    private Set<ZooAnimals> animals = new HashSet<>();

    public Zoo() {
    }

    public Zoo(long zooid, String zooname, Set<Telephone> telephones, Set<ZooAnimals> animals) {
        this.zooid = zooid;
        this.zooname = zooname;
        this.telephones = telephones;
        this.animals = animals;
    }

    public Set<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(Set<Telephone> telephones) {
        this.telephones = telephones;
    }

    public Set<ZooAnimals> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<ZooAnimals> animals) {
        this.animals = animals;
    }

    public long getZooid() {
        return zooid;
    }

    public void setZooid(long zooid) {
        this.zooid = zooid;
    }

    public String getZooname() {
        return zooname;
    }

    public void setZooname(String zooname) {
        this.zooname = zooname;
    }
}
