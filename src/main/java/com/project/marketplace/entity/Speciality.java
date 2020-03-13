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

//    public int hashCode() {
//        int lHashCode = 0;
//        if ( this.name != null ) {
//            lHashCode += this.name.hashCode();
//        }
//        if ( this.medecin != null ) {
//            lHashCode += this.medecin.hashCode();
//        }
//        if ( this.avoir != null ) {
//            lHashCode += this.avoir.hashCode();
//        }
//        if ( this.appartenir != null ) {
//            lHashCode += this.appartenir.hashCode();
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
//        } else if (object instanceof Speciality) {
//            Speciality lSpecialityObject = (Speciality) object;
//            boolean lEquals = true;
//            lEquals &= this.id == lSpecialityObject.id;
//            lEquals &= ((this.name == lSpecialityObject.name)
//                    || (this.name != null && this.name.equals(lSpecialityObject.name)));
//            lEquals &= this.priceSpeciality == lSpecialityObject.priceSpeciality;
//            lEquals &= ((this.medecin == lSpecialityObject.medecin)
//                    || (this.medecin != null && this.medecin.equals(lSpecialityObject.medecin)));
//            lEquals &= ((this.avoir == lSpecialityObject.avoir)
//                    || (this.avoir != null && this.avoir.equals(lSpecialityObject.avoir)));
//            lEquals &= ((this.appartenir == lSpecialityObject.appartenir)
//                    || (this.appartenir != null && this.appartenir.equals(lSpecialityObject.appartenir)));
//            return lEquals;
//        }
//        return false;
//    }


}
