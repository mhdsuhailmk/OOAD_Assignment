package com.ilp.service;

//import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.CurrentAccount;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class ProductConfiguration {

	
	
	
	//Create Service
	public static Service createService()
	{
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the service code");
		String serviceCode = scanner.nextLine();
	
		System.out.println("Enter the service name");
		String serviceName = scanner.nextLine();

		System.out.println("Enter the rate");
		double serviceRate  = scanner.nextDouble();
		
		Service service  = new Service(serviceCode, serviceName,serviceRate);

		return service;
		
	}
	
	
		
	
	//Create Savings Max Account
	public static SavingsMaxAccount createSavingsMaxAccount(ArrayList<Service> serviceList) {
		
		String productCode = "PCSM1";
		String productName = "Savings Account";
				
		Scanner scanner = new Scanner(System.in);
		
		int choice;
		char addMoreService;
		
		ArrayList<Service> selectedServiceList = new ArrayList<Service>();
		
		do {		
			//List All Services
			int i=1;
			System.out.println("\nChoose the services you want to add");
			for(Service service: serviceList) {
				
				System.out.println(i+". "+service.getServiceName());
				i++;
			}
			
			System.out.println("\nEnter your choice");
			choice = scanner.nextInt();
						
			switch(choice) {
			
			case 1:
				
				selectedServiceList.add(serviceList.get(0));
				break;
			
			case 2:
				selectedServiceList.add(serviceList.get(1));
				break;				
				
			case 3:
				selectedServiceList.add(serviceList.get(2));
				break;	
				
			case 4:
				selectedServiceList.add(serviceList.get(3));
				break;	
				
			}
			
			System.out.println("\nDo you want to add more?(Y/N)");
			addMoreService = scanner.next().charAt(0);
		
			//System.out.println(addMoreService);
		}while(addMoreService == 'Y' || addMoreService == 'y');
				
		SavingsMaxAccount savingsMaxAccount  = new SavingsMaxAccount(productCode, productName,selectedServiceList);
				
		return savingsMaxAccount;
		
	}
	
	
	
	
	
	//Create Current Account
	public static CurrentAccount createCurrentAccount(ArrayList<Service> serviceList) {
		
		String productCode = "PCCR1";
		String productName = "Current Account";
				
		Scanner scanner = new Scanner(System.in);
		
		int choice;
		char addMoreService;
		
		ArrayList<Service> selectedServiceList = new ArrayList<Service>();
		
		do {
			
			//List All Services
			int i=1;
			System.out.println("\nChoose the services you want to add");
			for(Service service: serviceList) {
				
				System.out.println(i+". "+service.getServiceName());
				i++;
			}
			
			
			System.out.println("\nEnter your choice");
			choice = scanner.nextInt();
						
			switch(choice) {
			
			case 1:
				
				selectedServiceList.add(serviceList.get(0));
				break;
			
			case 2:
				selectedServiceList.add(serviceList.get(1));
				break;				
				
			case 3:
				selectedServiceList.add(serviceList.get(2));
				break;	
				
			case 4:
				selectedServiceList.add(serviceList.get(3));
				break;	
				
			}
			
			System.out.println("\nDo you want to add more?(Y/N)");
			addMoreService = scanner.next().charAt(0);
		
			//System.out.println(addMoreService);
		}while(addMoreService == 'Y' || addMoreService == 'y');
						
		CurrentAccount currentAccount  = new CurrentAccount(productCode, productName,selectedServiceList);
				
		return currentAccount;
		
	}
	

	
	
	
	//Create Loan Account
	public static LoanAccount createLoanAccount(ArrayList<Service> serviceList) {
		
		String productCode = "PCSM1";
		String productName = "Loan Account";
				
		Scanner scanner = new Scanner(System.in);
		
		int choice;
		char addMoreService;
		
		ArrayList<Service> selectedServiceList = new ArrayList<Service>();
		
		
		do {
			
			//List All Services
			int i=1;
			System.out.println("\nChoose the services you want to add");
			for(Service service: serviceList) {
				
				System.out.println(i+". "+service.getServiceName());
				i++;
			}
			
			
			System.out.println("\nEnter your choice");
			choice = scanner.nextInt();
						
			switch(choice) {
			
			case 1:
				
				selectedServiceList.add(serviceList.get(0));
				break;
			
			case 2:
				selectedServiceList.add(serviceList.get(1));
				break;				
				
			case 3:
				selectedServiceList.add(serviceList.get(2));
				break;	
				
			case 4:
				selectedServiceList.add(serviceList.get(3));
				break;	
				
			}
			
			System.out.println("\nDo you want to add more?(Y/N)");
			addMoreService = scanner.next().charAt(0);
		
			//System.out.println(addMoreService);
		}while(addMoreService == 'Y' || addMoreService == 'y');
		
					
		LoanAccount loanAccount  = new LoanAccount(productCode, productName,selectedServiceList);
				
		return loanAccount;
		
	}


	


	//Deposit Money
	public static void depositMoney(ArrayList<Customer> customerList) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Customer ID");
		String customerId = scanner.nextLine();
	
		LoanAccount loanAccount = null;
		
		for(Customer customer: customerList) {
			
			//Searching Customer
			if(customer.getCustomerCode().equals(customerId)) {
									
				//List All Accounts
				System.out.println("Choose The Account");
				int i=1;
				
				for(Account account: customer.getAccountList()) {
					
					System.out.println(i+". "+account.getAccountProduct().getProductName());
					i++;
				}
				
				int choice = scanner.nextInt();

				Account accountSelected = customer.getAccountList().get(choice-1);
								
				System.out.println("Enter The Amount");
				double amount  = scanner.nextDouble();
				
				double currentBalance  = accountSelected.getAccountBalance();
				
				
				
				
				if( accountSelected.getAccountProduct() instanceof LoanAccount) {
					
					System.out.println("Is it a Cheque Deposit? (Y/N)");
					char chequeDeposit = scanner.next().charAt(0);
					
					if(chequeDeposit=='Y' || chequeDeposit == 'y') {
						
					
						
					loanAccount = (LoanAccount)accountSelected.getAccountProduct();
					//getting percentage of ceque deposit charge
					double chequeDepositRate  = loanAccount.getLoanAccountChequeDepositCharge();
						
						
						
					System.out.println("Cheque Deposit Charges Applicable");
					double chequeDepositCharge = amount * chequeDepositRate;
					amount  = amount - chequeDepositCharge;
					
					accountSelected.setAccountBalance(currentBalance+amount);
					System.out.print("Rs. "+amount+" has been deposited!");

					}	
					else {
						
						accountSelected.setAccountBalance(currentBalance+amount);
						System.out.print("Rs. "+amount+" has been deposited!");

						
					}

					
				}
					
				else {
					accountSelected.setAccountBalance(currentBalance+amount);
					System.out.print("Rs. "+amount+" has been deposited!");

				}
				
			
			//end_of_if	
			}
			
		
		//end_of_customer_list_looping	
		}
		
		
		//end of function
	}
	




	//Withdraw Money
	public static void withdrawMoney(ArrayList<Customer> customerList) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Customer ID");
		String customerId = scanner.nextLine();
	
		SavingsMaxAccount savingsMaxAccount = null;

		
		
		for(Customer customer: customerList) {
			
			//Searching Customer
			if(customer.getCustomerCode().equals(customerId)) {
								
				
				//List All Accounts
				System.out.println("Choose The Account");
				int i=1;
				for(Account account: customer.getAccountList()) {
					
					System.out.println(i+". "+account.getAccountProduct().getProductName());
					i++;
				}
				
				
				int choice = scanner.nextInt();

				Account accountSelected = customer.getAccountList().get(choice-1);
								
				System.out.println("Enter The Amount");
				double amount  = scanner.nextDouble();
				double currentBalance = accountSelected.getAccountBalance();
				
			
				//Savings Account
				if(accountSelected.getAccountProduct() instanceof SavingsMaxAccount ) {
					
					
					savingsMaxAccount = (SavingsMaxAccount)accountSelected.getAccountProduct();

					double minBalanceNeeded = savingsMaxAccount.getMinBalance();

					
					if((currentBalance - amount) < minBalanceNeeded) {
						
						System.out.println("Minimum Balance of 1000 Need to be Kept!");
						
					}else {
						
						accountSelected.setAccountBalance( currentBalance -  amount);
						System.out.print("Rs. "+amount+" has been withdrawn!");
					}
					
				}
				//other accounts
				else {
					
					accountSelected.setAccountBalance( currentBalance -  amount);
					System.out.print("Rs. "+amount+" has been withdrawn!");
				}
				
	
			
			//end_of_if	
			}
			
		
		//end_of_customer_list_looping	
		}
		

		//end of function
				
		
	}
	
	
	
	
	
	
}
