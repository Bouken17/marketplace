package com.project.marketplace.entity;

import javax.persistence.*;

@Entity
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private double priceSpeciality;
//    ArrayList<Medecin> medecin = new ArrayList<Medecin>();
//    ArrayList<Provider> avoir = new ArrayList<Provider>();
//    ArrayList<Product> appartenir = new ArrayList<Product>();

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPriceSpeciality(double priceSpeciality) {
        this.priceSpeciality = priceSpeciality;
    }

    public double getPriceSpeciality() {
        return this.priceSpeciality;
    }

}
