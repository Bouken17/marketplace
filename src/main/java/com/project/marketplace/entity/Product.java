package com.project.marketplace.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private String catalogue;
	@Column
	private String reference;
	@Column
	private long nombreVue;
	@Column
	private String marque;
	@Column
	private boolean blocked=false;
	@ManyToOne
	@JoinColumn(name = "provider_id")
	private Provider provider;
	@OneToMany
	@JoinColumn(name = "product_id")
	private List<Image> images;
//	ArrayList<Complaint> reclamer = new ArrayList<Complaint>();
//	ArrayList<Date_Quotation> date_Quotation = new ArrayList<Date_Quotation>();
//	Speciality appartenir;
//	Provider provider;


	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public void setId(long id) { this.id = id; }

	public long getId() { return this.id; }

	public void setName(String name) { this.name = name; }

	public String getName() { return this.name; }

	public void setDescription(String description) { this.description = description; }

	public String getDescription() { return this.description; }

	public void setCatalogue(String catalogue) { this.catalogue = catalogue; }

	public String getCatalogue() { return this.catalogue; }

	public void setReference(String reference) { this.reference = reference; }

	public String getReference() { return this.reference; }

	public void setNombreVue(long nombreVue) { this.nombreVue = nombreVue; }

	public long getNombreVue() { return this.nombreVue; }

	public void setMarque(String marque) { this.marque = marque; }

	public String getMarque() {
		return this.marque;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	//	public int hashCode() {
//		int lHashCode = 0;
//		if ( this.name != null ) {
//			lHashCode += this.name.hashCode();
//		}
//		if ( this.description != null ) {
//			lHashCode += this.description.hashCode();
//		}
//		if ( this.catalogue != null ) {
//			lHashCode += this.catalogue.hashCode();
//		}
//		if ( this.reference != null ) {
//			lHashCode += this.reference.hashCode();
//		}
//		if ( this.marque != null ) {
//			lHashCode += this.marque.hashCode();
//		}
//		if ( this.posseder != null ) {
//			lHashCode += this.posseder.hashCode();
//		}
//		if ( this.reclamer != null ) {
//			lHashCode += this.reclamer.hashCode();
//		}
//		if ( this.date_Quotation != null ) {
//			lHashCode += this.date_Quotation.hashCode();
//		}
//		if ( this.appartenir != null ) {
//			lHashCode += this.appartenir.hashCode();
//		}
//		if ( this.provider != null ) {
//			lHashCode += this.provider.hashCode();
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
//		} else if (object instanceof Product) {
//			Product lProductObject = (Product) object;
//			boolean lEquals = true;
//			lEquals &= this.id == lProductObject.id;
//			lEquals &= ((this.name == lProductObject.name)
//					|| (this.name != null && this.name.equals(lProductObject.name)));
//			lEquals &= ((this.description == lProductObject.description)
//					|| (this.description != null && this.description.equals(lProductObject.description)));
//			lEquals &= ((this.catalogue == lProductObject.catalogue)
//					|| (this.catalogue != null && this.catalogue.equals(lProductObject.catalogue)));
//			lEquals &= ((this.reference == lProductObject.reference)
//					|| (this.reference != null && this.reference.equals(lProductObject.reference)));
//			lEquals &= this.nombreVue == lProductObject.nombreVue;
//			lEquals &= ((this.marke == lProductObject.marke)
//					|| (this.marke != null && this.marke.equals(lProductObject.marke)));
//			lEquals &= ((this.posseder == lProductObject.posseder)
//					|| (this.posseder != null && this.posseder.equals(lProductObject.posseder)));
//			lEquals &= ((this.reclamer == lProductObject.reclamer)
//					|| (this.reclamer != null && this.reclamer.equals(lProductObject.reclamer)));
//			lEquals &= ((this.date_Quotation == lProductObject.date_Quotation)
//					|| (this.date_Quotation != null && this.date_Quotation.equals(lProductObject.date_Quotation)));
//			lEquals &= ((this.appartenir == lProductObject.appartenir)
//					|| (this.appartenir != null && this.appartenir.equals(lProductObject.appartenir)));
//			lEquals &= ((this.provider == lProductObject.provider)
//					|| (this.provider != null && this.provider.equals(lProductObject.provider)));
//			return lEquals;
//		}
//		return false;
//	}

}
