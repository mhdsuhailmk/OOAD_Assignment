package com.ilp.entity;

import java.util.ArrayList;

public class SavingsMaxAccount extends Product{
	
	
	
	private double minBalance=1000;
	
	

	public SavingsMaxAccount(String productCode, String productName, ArrayList<Service> servicesList) {
		super(productCode, productName, servicesList);
		// TODO Auto-generated constructor stub
	}



	public double getMinBalance() {
		return minBalance;
	}



	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}




	
	
	
}
