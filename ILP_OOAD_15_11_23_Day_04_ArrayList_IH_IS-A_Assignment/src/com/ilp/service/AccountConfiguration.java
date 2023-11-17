package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;

public class AccountConfiguration {

	
	
	//Create Customer
	public static Customer createCustomer(ArrayList<Service> serviceList) {
		

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Customer Code");
		String customerCode = scanner.nextLine();
		
		System.out.println("Enter Customer Name");
		String customerName = scanner.nextLine();
		
		ArrayList<Account> accountList = createAccount(serviceList);
		
		return new Customer(customerCode, customerName, accountList);
		
	}
	

	
	
	
	
	
	//Create Account
	public static ArrayList<Account> createAccount(ArrayList<Service> serviceList) {
		
		
			Scanner scanner  = new Scanner(System.in);
			ArrayList<Account> accountList = new ArrayList<Account>();
			
			Product selectedProduct=null;
			char addMoreAccount;
			
			do
			{				
				
				System.out.println("\nCreate a new Account");
				
				System.out.println("\n********************Products Available**********************");
				
				System.out.println("\n1. Savings Max Account \n2. Current Account \n3. Loan Account");
										
				System.out.println("\nEnter your choice");
				int choice  = scanner.nextInt();
				
				System.out.println("\n----------------------------------------------------------------\n");
				
				System.out.println("Enter Account Number");
				String accountNo = scanner.next();
			
				System.out.println("Enter the Balance");
				double accountBalance = scanner.nextDouble();
				
				System.out.println("\n----------------------------------------------------------------\n");

				
				switch(choice) {
				
					case 1:
						
						selectedProduct = ProductConfiguration.createSavingsMaxAccount(serviceList);
						break;
						
					case 2:	
						selectedProduct = ProductConfiguration.createCurrentAccount(serviceList);
						break;
						
					case 3:
						selectedProduct = ProductConfiguration.createLoanAccount(serviceList);
						break;
				
				//end of switch		
				}

				
			
			
			Account account  = new Account(accountNo, accountBalance, selectedProduct);
			accountList.add(account);
			
			System.out.println("\n________________________________________________________________");
			System.out.println("***********************Account is Active!************************");
			System.out.println("_________________________________________________________________\n");

			
			System.out.println("Do you want to create another account?(y/n)");
			addMoreAccount = scanner.next().charAt(0);
					
			//end of do	
			}while(addMoreAccount == 'y' || addMoreAccount == 'Y');

			
			return accountList;
			
	}
	//Create Account Ends

	
	
	
	
	
	
	
	
	//Display Customer
	public static void displayCustomer(ArrayList<Customer> customerList) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Customer Code");
		String customerCode = scanner.nextLine();
		
		
		for(Customer customer: customerList) {
			
			
			//Matching Customer
			if(customer.getCustomerCode().equals(customerCode)) {
				
				
				System.out.println("========================================CUSTOMER ACCOUNTS==========================================");
				System.out.println("\nCustomer ID    Customer Name     Account No             Balance        Product");
				System.out.println("--------------------------------------------------------------------------------------------------");
				
				for(Account account: customer.getAccountList()) {
					
					System.out.println(customer.getCustomerCode()+"               "+customer.getCustomerName()+"                "+ account.getAccountNo()+"              "+account.getAccountBalance()+"            "+account.getAccountProduct().getProductName());

					
					//Display Services
					System.out.println("\n////////////////////////////////Services Opted!////////////////////////////////////////////");
					for( Service service: account.getAccountProduct().getServicesList() ) {
						System.out.print(" "+service.getServiceName());
					}
					
					System.out.println("\n_____________________________________________________________________________________________\n");

				
				//end_of_for_loop_2-accountList_iteration	
				}

				System.out.println("====================================================================================================");
			
			
			//end_of_if	
			}
			
		//end_of_for_loop_1-customer-iteration
		}
		
	
	}
	//Display Customer Ends



	
	
	
	//Transaction Bill
	public static void transactionBill(ArrayList<Service> serviceList) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("*********************************TRANSACTION BILL***********************************");
		System.out.println("------------------------------------------------------------------------------------");
		
		double selectedServiceCost=0;
		
		double totalAmount=0;

		System.out.println("Enter The Service Code:");
		String serviceCode = scanner.next();
		
		System.out.println("Enter The Number of Transactions:");
		int noOfTransactions = scanner.nextInt();		
		
		
		for(Service service: serviceList) {
			
			if( service.getServiceCode().equals(serviceCode)) {
			
				selectedServiceCost = service.getServiceRate();
				System.out.println("\n================================================");

				System.out.println("Service Code      Service Name     Service Rate");
				System.out.println("------------------------------------------------"); 
				System.out.println(service.getServiceCode()+"                  "+service.getServiceName() +"               "+service.getServiceRate());
				System.out.println("------------------------------------------------");
				
				totalAmount = selectedServiceCost * noOfTransactions;
				break;
			}
			
		}
		
		//System.out.println("------------------------------------------------");

		System.out.println("                              Total Amount: "+totalAmount);
		
		System.out.println("==================================================");

	}
	
	//Transaction Bill Ends

	
	
	

	
	
}
