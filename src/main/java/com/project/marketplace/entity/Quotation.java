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
