package com.albert.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class Product implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	private int id;
	private String productDescriptionEnglish;
	private String productDescriptionFrench;
	private String brandNameEnglish;
	private String brandNameFrench;
	private String productType;
	private String additionalProductIdentification;
	private String targetMarket;
	private String productImageUrl;
	private String status;
	
	public String getBrandNameEnglish() {
		return brandNameEnglish;
	}
	public void setBrandNameEnglish(String brandNameEnglish) {
		this.brandNameEnglish = brandNameEnglish;
	}
	public String getBrandNameFrench() {
		return brandNameFrench;
	}
	public void setBrandNameFrench(String brandNameFrench) {
		this.brandNameFrench = brandNameFrench;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getAdditionalProductIdentification() {
		return additionalProductIdentification;
	}
	public void setAdditionalProductIdentification(String additionalProductIdentification) {
		this.additionalProductIdentification = additionalProductIdentification;
	}
	public String getTargetMarket() {
		return targetMarket;
	}
	public void setTargetMarket(String targetMarket) {
		this.targetMarket = targetMarket;
	}
	public String getProductImageUrl() {
		return productImageUrl;
	}
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	

	
	public String getProductDescriptionFrench() {
		return productDescriptionFrench;
	}
	public void setProductDescriptionFrench(String productDescriptionFrench) {
		this.productDescriptionFrench = productDescriptionFrench;
	}
	public String getProductDescriptionEnglish() {
		return productDescriptionEnglish;
	}
	public void setProductDescriptionEnglish(String productDescriptionEnglish) {
		this.productDescriptionEnglish = productDescriptionEnglish;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
