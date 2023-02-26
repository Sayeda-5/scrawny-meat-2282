package com.masai.UI;

import java.util.Scanner;

import com.masai.dao.CustomerDAOImpl;
import com.masai.dto.Customer;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWrongException;

public class Main {
	private static CustomerUI customerUI;
//	private static AccountUI accountUI;

	static void adminLogin(Scanner sc) throws SomeThingWrongException, NoRecordFoundException {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			printAdminMenu(sc);
		}else {
			System.out.println("Invalid Username and Password");
		}
	}

	static void printAdminMenu(Scanner sc) throws SomeThingWrongException, NoRecordFoundException {
		int choice = 0;
		do {
			System.out.println("1. Add new Customer");
			System.out.println("2. View All Customer");
			System.out.println("3. Update a Customer");
			System.out.println("4. Delete a Customer");
			System.out.println("5. Search Customer by Account Number");
			System.out.println("6. Search Customer by Id");
			System.out.println("0. for Exit");
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					customerUI.addCustomer();
					break;
				case 2:
					customerUI.getCustomerList();
					break;
				case 3:
					customerUI.updateCustomer();
					break;
				case 4:
					customerUI.deleteCustomer();
					break;
				case 5:
					customerUI.findByEmailId();
					break;
                case 6:
					
					break;
				
			}
		}while(choice != 0);
	}

	static void customerLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		
		//call DAO method to check if username and password is correct, from this method get object of User id
		//LoggedINUser.loggedInUserId = userId; this will make user id available to you everywhere
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		customerUI = new CustomerUI(sc);
		int choice = 0;
		do {
			System.out.println("1. Admin Login\n2. Customer Login\n0. Exit");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					adminLogin(sc);
					break;
				case 2:
					customerLogin(sc);
					break;
				default:
					System.out.println("Invalid Selection, try again");
			}
		}while(choice != 0);
		sc.close();
	}
}
