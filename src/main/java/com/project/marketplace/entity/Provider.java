package com.project.marketplace.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String lastname;
    @Column
    private String firstname;
    @Column
    private boolean admin;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String tel;
    @Column
    private int status;
    @Column
    private boolean type;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Society")
    private Society Society;
//    ArrayList<Product> product = new ArrayList<Product>();

//    List<Speciality> Specialities;
//    AbstractAdmin abstractAdmin;


    public void setId(long id) { this.id = id; }

    public long getId() { return this.id; }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean isType() {
        return this.type;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Society getAppartenir() {
        return Society;
    }

    public void setAppartenir(Society appartenir) {
        this.Society = appartenir;
    }

}
