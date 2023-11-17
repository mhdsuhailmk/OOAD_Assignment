package com.ilp.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;
import com.ilp.service.AccountConfiguration;
import com.ilp.service.ProductConfiguration;

public class AccountUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method

		Customer customer = null;
		Service service = null;

		ArrayList<Service> serviceList = new ArrayList<Service>();
		ArrayList<Customer> customerList = new ArrayList<Customer>();

		Scanner scanner = new Scanner(System.in);

		char goToMainMenu;
		System.out.println("********************** WELCOME TO THE BANK *********************");

		do {

			System.out.println("\n---------------------------------------------------------------");
			System.out.println(
					"\n1. Create Service  \n2. Create Account \n3. Transaction Bill \n4. Display Customer \n5. Deposit  \n6. Withdraw");
			System.out.println("\n--------------------------------------------------------------\n");

			System.out.println("\nEnter your choice:");
			int mainMenuChoice = scanner.nextInt();

			switch (mainMenuChoice) {

			case 1:
				service = ProductConfiguration.createService();
				serviceList.add(service);
				break;

			case 2:
				// Create Account
				customer = AccountConfiguration.createCustomer(serviceList);
				customerList.add(customer);
				break;

			case 3:
				AccountConfiguration.transactionBill(serviceList);
				break;

			case 4:
				AccountConfiguration.displayCustomer(customerList);
				break;

			case 5:
				ProductConfiguration.depositMoney(customerList);
				break;

			case 6:
				ProductConfiguration.withdrawMoney(customerList);
				break;

			}

			System.out.println("\nGo Back to Main Menu (Y/N)?");
			goToMainMenu = scanner.next().charAt(0);

		} while (goToMainMenu == 'y' || goToMainMenu == 'Y');

	}

}
