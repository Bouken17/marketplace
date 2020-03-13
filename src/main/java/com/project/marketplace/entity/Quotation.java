package com.project.marketplace.entity;


import javax.persistence.*;

@Entity
public class Quotation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String lastname;
	@Column
	private String firstname;
	@Column
	private String email;
	@Column
	private String address;
	@Column
	private String quantity;
	@Column
	private long postalCode;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

//	public int hashCode() {
//		int lHashCode = 0;
//		if ( this.lastname != null ) {
//			lHashCode += this.lastname.hashCode();
//		}
//		if ( this.firstname != null ) {
//			lHashCode += this.firstname.hashCode();
//		}
//		if ( this.email != null ) {
//			lHashCode += this.email.hashCode();
//		}
//		if ( this.address != null ) {
//			lHashCode += this.address.hashCode();
//		}
//		if ( this.quantity != null ) {
//			lHashCode += this.quantity.hashCode();
//		}
//		if ( this.date_Quotation != null ) {
//			lHashCode += this.date_Quotation.hashCode();
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
//		} else if (object instanceof quotation) {
//			quotation lQuotationObject = (quotation) object;
//			boolean lEquals = true;
//			lEquals &= this.id == lQuotationObject.id;
//			lEquals &= ((this.lastname == lQuotationObject.lastname)
//				|| (this.lastname != null && this.lastname.equals(lQuotationObject.lastname)));
//			lEquals &= ((this.firstname == lQuotationObject.firstname)
//				|| (this.firstname != null && this.firstname.equals(lQuotationObject.firstname)));
//			lEquals &= ((this.email == lQuotationObject.email)
//				|| (this.email != null && this.email.equals(lQuotationObject.email)));
//			lEquals &= ((this.address == lQuotationObject.address)
//				|| (this.address != null && this.address.equals(lQuotationObject.address)));
//			lEquals &= ((this.quantity == lQuotationObject.quantity)
//				|| (this.quantity != null && this.quantity.equals(lQuotationObject.quantity)));
//			lEquals &= this.postalCode == lQuotationObject.postalCode;
//			lEquals &= ((this.date_Quotation == lQuotationObject.date_Quotation)
//				|| (this.date_Quotation != null && this.date_Quotation.equals(lQuotationObject.date_Quotation)));
//			return lEquals;
//		}
//		return false;
//	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
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

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setPostalCode(long postalCode) {
		this.postalCode = postalCode;
	}

	public long getPostalCode() {
		return this.postalCode;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
