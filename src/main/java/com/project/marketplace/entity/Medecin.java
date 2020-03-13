package com.project.marketplace.entity;

import javax.persistence.*;

@Entity
public class Medecin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private boolean admin = false;
	@Column
	private String tel;
//	@OneToMany
//	@JoinColumn(name = "Speciality")
//	Speciality speciality;

	public void RequestQuotation() {
		throw new UnsupportedOperationException();
	}

//	public int hashCode() {
//		int lHashCode = 0;
//		if ( this.nom != null ) {
//			lHashCode += this.nom.hashCode();
//		}
//		if ( this.prenom != null ) {
//			lHashCode += this.prenom.hashCode();
//		}
//		if ( this.password != null ) {
//			lHashCode += this.password.hashCode();
//		}
//		if ( this.email != null ) {
//			lHashCode += this.email.hashCode();
//		}
//		if ( this.tel != null ) {
//			lHashCode += this.tel.hashCode();
//		}
//		if ( this.speciality != null ) {
//			lHashCode += this.speciality.hashCode();
//		}
//		if ( lHashCode == 0 ) {
//			lHashCode = super.hashCode();
//		}
//		return lHashCode;
//	}
//
//	public boolean equals(Object object) {
//		if (this == object) {
//			return true;
//		} else if (object instanceof Medecin) {
//			Medecin lMedecinObject = (Medecin) object;
//			boolean lEquals = true;
//			lEquals &= this.id == lMedecinObject.id;
//			lEquals &= ((this.nom == lMedecinObject.nom)
//				|| (this.nom != null && this.nom.equals(lMedecinObject.nom)));
//			lEquals &= ((this.prenom == lMedecinObject.prenom)
//				|| (this.prenom != null && this.prenom.equals(lMedecinObject.prenom)));
//			lEquals &= ((this.password == lMedecinObject.password)
//				|| (this.password != null && this.password.equals(lMedecinObject.password)));
//			lEquals &= ((this.email == lMedecinObject.email)
//				|| (this.email != null && this.email.equals(lMedecinObject.email)));
//			lEquals &= this.admin == lMedecinObject.admin;
//			lEquals &= ((this.tel == lMedecinObject.tel)
//				|| (this.tel != null && this.tel.equals(lMedecinObject.tel)));
//			lEquals &= ((this.speciality == lMedecinObject.speciality)
//				|| (this.speciality != null && this.speciality.equals(lMedecinObject.speciality)));
//			return lEquals;
//		}
//		return false;
//	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}
}
