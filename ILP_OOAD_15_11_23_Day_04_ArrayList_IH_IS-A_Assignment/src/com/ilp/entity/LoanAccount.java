package com.ilp.entity;

import java.util.ArrayList;

public class LoanAccount extends Product{
	
	private double loanAccountChequeDepositCharge=0.03;

	public double getLoanAccountChequeDepositCharge() {
		return loanAccountChequeDepositCharge;
	}

	public void setLoanAccountChequeDepositCharge(double loanAccountChequeDepositCharge) {
		this.loanAccountChequeDepositCharge = loanAccountChequeDepositCharge;
	}

	public LoanAccount(String productCode, String productName, ArrayList<Service> servicesList) {
		super(productCode, productName, servicesList);
		// TODO Auto-generated constructor stub
	}

}
