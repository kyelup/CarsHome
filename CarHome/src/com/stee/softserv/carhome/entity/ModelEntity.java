package com.stee.softserv.carhome.entity;

import java.io.Serializable;

public class ModelEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3841540119196376694L;

	private int id;
	private String modelName;
	private int brandId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

}
