package com.ilp.entity;

import java.util.ArrayList;

public abstract class Product {

	private String productCode;
	private String productName;
	ArrayList<Service> servicesList = new ArrayList<Service>();
	
	
	public Product(String productCode, String productName, ArrayList<Service> servicesList) {
		
		this.productCode = productCode;
		this.productName = productName;
		this.servicesList = servicesList;
	}
	
	
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	public ArrayList<Service> getServicesList() {
		return servicesList;
	}

	
	
}
