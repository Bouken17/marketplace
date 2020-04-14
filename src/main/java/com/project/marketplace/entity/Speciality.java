package com.project.marketplace.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private String image;
    @Column
    private double priceSpeciality;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Specialities")
    private List<Provider> providers;
//    ArrayList<Medecin> medecin = new ArrayList<Medecin>();
//    ArrayList<Provider> avoir = new ArrayList<Provider>();
//    ArrayList<Product> appartenir = new ArrayList<Product>();

    public Speciality() {}

    public Speciality(String name, double priceSpeciality, String image) {
        this.name = name.toUpperCase();
        this.priceSpeciality = priceSpeciality;
        this.image = image;
    }

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

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
