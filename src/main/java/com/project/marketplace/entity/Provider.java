package com.project.marketplace.entity;

import javax.persistence.*;
import java.util.ArrayList;

public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String lastname;
    @Column
    private String firstname;
    @Column
    private boolean admin = false;
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
    @OneToOne
    private Society appartenir;
//    ArrayList<Product> product = new ArrayList<Product>();
    @JoinColumn
    @OneToMany
    ArrayList<Speciality> Specialities = new ArrayList<Speciality>();
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





//    public int hashCode() {
//        int lHashCode = 0;
//        if ( this.lastname != null ) {
//            lHashCode += this.lastname.hashCode();
//        }
//        if ( this.firstname != null ) {
//            lHashCode += this.firstname.hashCode();
//        }
//        if ( this.email != null ) {
//            lHashCode += this.email.hashCode();
//        }
//        if ( this.password != null ) {
//            lHashCode += this.password.hashCode();
//        }
//        if ( this.tel != null ) {
//            lHashCode += this.tel.hashCode();
//        }
//        if ( this.appartenir != null ) {
//            lHashCode += this.appartenir.hashCode();
//        }
//        if ( this.product != null ) {
//            lHashCode += this.product.hashCode();
//        }
//        if ( this.avoir != null ) {
//            lHashCode += this.avoir.hashCode();
//        }
//        if ( this.abstractAdmin != null ) {
//            lHashCode += this.abstractAdmin.hashCode();
//        }
//        if ( lHashCode == 0 ) {
//            lHashCode = super.hashCode();
//        }
//        return lHashCode;
//    }
//
//    public boolean equals(Object object) {
//        if (this == object) {
//            return true;
//        } else if (object instanceof Provider) {
//            Provider lProviderObject = (Provider) object;
//            boolean lEquals = true;
//            lEquals &= this.id == lProviderObject.id;
//            lEquals &= ((this.lastname == lProviderObject.lastname)
//                    || (this.lastname != null && this.lastname.equals(lProviderObject.lastname)));
//            lEquals &= ((this.firstname == lProviderObject.firstname)
//                    || (this.firstname != null && this.firstname.equals(lProviderObject.firstname)));
//            lEquals &= this.admin == lProviderObject.admin;
//            lEquals &= ((this.email == lProviderObject.email)
//                    || (this.email != null && this.email.equals(lProviderObject.email)));
//            lEquals &= ((this.password == lProviderObject.password)
//                    || (this.password != null && this.password.equals(lProviderObject.password)));
//            lEquals &= ((this.tel == lProviderObject.tel)
//                    || (this.tel != null && this.tel.equals(lProviderObject.tel)));
//            lEquals &= this.status == lProviderObject.status;
//            lEquals &= this.type == lProviderObject.type;
//            lEquals &= ((this.appartenir == lProviderObject.appartenir)
//                    || (this.appartenir != null && this.appartenir.equals(lProviderObject.appartenir)));
//            lEquals &= ((this.product == lProviderObject.product)
//                    || (this.product != null && this.product.equals(lProviderObject.product)));
//            lEquals &= ((this.avoir == lProviderObject.avoir)
//                    || (this.avoir != null && this.avoir.equals(lProviderObject.avoir)));
//            lEquals &= ((this.abstractAdmin == lProviderObject.abstractAdmin)
//                    || (this.abstractAdmin != null && this.abstractAdmin.equals(lProviderObject.abstractAdmin)));
//            return lEquals;
//        }
//        return false;
//    }



}
