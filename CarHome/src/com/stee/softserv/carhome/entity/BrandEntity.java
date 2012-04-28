package com.stee.softserv.carhome.entity;

import java.io.Serializable;

public class BrandEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4329975638536004443L;
	private int id;

	private String brandName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

}
