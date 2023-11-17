package com.ilp.entity;

public class Account {

	private String accountNo;
	private double accountBalance;
	private Product accountProduct;
	
	
	public Account(String accountNo, double accountBalance, Product accountProduct) {
		
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
		this.accountProduct = accountProduct;
	}
	
	
	public String getAccountNo() {
		return accountNo;
	}
	
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	
	
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
	public Product getAccountProduct() {
		return accountProduct;
	}
	
	
	public void setAccountProduct(Product accountProduct) {
		this.accountProduct = accountProduct;
	}
	
	
	
}
