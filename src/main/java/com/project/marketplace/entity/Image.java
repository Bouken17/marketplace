package com.project.marketplace.entity;

import javax.persistence.*;

@Entity
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String name;
	@Column
	private String path;
	@Column
	private long idProduct;

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

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return this.path;
	}

	public long getIdProduct() { return idProduct; }

	public void setIdProduct(long idProduct) { this.idProduct = idProduct; }
//	public int hashCode() {
//		int lHashCode = 0;
//		if ( this.name != null ) {
//			lHashCode += this.name.hashCode();
//		}
//		if ( this.path != null ) {
//			lHashCode += this.path.hashCode();
//		}
//		if ( this.posseder != null ) {
//			lHashCode += this.posseder.hashCode();
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
//		} else if (object instanceof Image) {
//			Image lImageObject = (Image) object;
//			boolean lEquals = true;
//			lEquals &= this.id == lImageObject.id;
//			lEquals &= ((this.name == lImageObject.name)
//				|| (this.name != null && this.name.equals(lImageObject.name)));
//			lEquals &= ((this.path == lImageObject.path)
//				|| (this.path != null && this.path.equals(lImageObject.path)));
//			lEquals &= ((this.posseder == lImageObject.posseder)
//				|| (this.posseder != null && this.posseder.equals(lImageObject.posseder)));
//			return lEquals;
//		}
//		return false;
//	}

}
