package com.project.marketplace.entity;

import javax.persistence.*;

@Entity
public class Society {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private String numero_tel;
    @Column
    private String email;
    @OneToOne
    private Provider responsable;


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

    public void setNumero_tel(String numero_tel) {
        this.numero_tel = numero_tel;
    }

    public String getNumero_tel() {
        return this.numero_tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

//    public int hashCode() {
//        int lHashCode = 0;
//        if ( this.name != null ) {
//            lHashCode += this.name.hashCode();
//        }
//        if ( this.numero_tel != null ) {
//            lHashCode += this.numero_tel.hashCode();
//        }
//        if ( this.email != null ) {
//            lHashCode += this.email.hashCode();
//        }
//        if ( this.responsable != null ) {
//            lHashCode += this.responsable.hashCode();
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
//        } else if (object instanceof Society) {
//            Society lSocietyObject = (Society) object;
//            boolean lEquals = true;
//            lEquals &= this.id == lSocietyObject.id;
//            lEquals &= ((this.name == lSocietyObject.name)
//                    || (this.name != null && this.name.equals(lSocietyObject.name)));
//            lEquals &= ((this.numero_tel == lSocietyObject.numero_tel)
//                    || (this.numero_tel != null && this.numero_tel.equals(lSocietyObject.numero_tel)));
//            lEquals &= ((this.email == lSocietyObject.email)
//                    || (this.email != null && this.email.equals(lSocietyObject.email)));
//            lEquals &= ((this.responsable == lSocietyObject.responsable)
//                    || (this.responsable != null && this.responsable.equals(lSocietyObject.responsable)));
//            return lEquals;
//        }
//        return false;
//    }


}
