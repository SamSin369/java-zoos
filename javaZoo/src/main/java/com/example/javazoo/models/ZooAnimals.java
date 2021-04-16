package com.example.javazoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "zooanimals")
@IdClass(ZooAnimalsId.class)
public class ZooAnimals extends Auditable implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "animalid")
    @JsonIgnoreProperties(value = "animals")
    private Animal animal;


    @Id
    @ManyToOne
    @JoinColumn(name="zooid")
    @JsonIgnoreProperties(value = "zoos")
    private Zoo zoo;

    @Column(nullable = false)
    private String incomingzoo;
    public ZooAnimals() {
    }

    public ZooAnimals(Animal animal, Zoo zoo, String incomingzoo) {
        this.animal = animal;
        this.zoo = zoo;
        this.incomingzoo = incomingzoo;
    }

    public String getIncomingzoo() {
        return incomingzoo;
    }

    public void setIncomingzoo(String incomingzoo) {
        this.incomingzoo = incomingzoo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZooAnimals)) return false;
        ZooAnimals that = (ZooAnimals) o;
        return ((this.zoo == null) ? 0 : this.zoo.getZooid()) == ((that.zoo == null) ? 0 : that.zoo.getZooid()) &&
                ( this.animal.getAnimalid() ==  that.animal.getAnimalid());

    }

    @Override
    public int hashCode() {
        return 69;
    }
}
