package com.training.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class collectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		
//		List<String> names = new ArrayList<>();
//		names.add("Ahmed");
//		names.add("Hassan");
//		names.add("ali");
//		
//		
//		for(String name:names) {
//			System.out.println(name);
//		}
//		
//		Set<Employee> empSet = new HashSet<>();
//		empSet.add(new Employee(101, "ghaith", "it" , 2000));
//		empSet.add(new Employee(102, "Ali", "sales" , 3000));
//						
//		for(Employee emp:empSet) {
//		System.out.println(emp);
//		}	

		
//		Iterator<String> iter = names.iterator();
//		while (iter.hasNext()) {
//			System.out.println(names);
//		}
//			
		
		
		 Scanner scanner = Customer.getScanner(); 

	        List<Runnable> menuActions = new ArrayList<>();
	        menuActions.add(Customer::addCustomer);   
	        menuActions.add(Customer::updateCustomer); 
	        menuActions.add(Customer::deleteCustomer); 
	        menuActions.add(Customer::showCustomers); 
	        menuActions.add(() -> { 
	            System.out.println("Exiting program...");
	            scanner.close();
	            System.exit(0);
	        });

	        while (true) {
	            System.out.println("\n Customer Management System");
	            System.out.println("1️:Add Customer");
	            System.out.println("2️: Update Customer");
	            System.out.println("3️: Delete Customer");
	            System.out.println("4️: Show All Customers");
	            System.out.println("5️: Exit");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();

	            if (choice >= 1 && choice <= menuActions.size()) {
	                menuActions.get(choice - 1).run();
	            } else {
	                System.out.println("Invalid choice! Please try again.");
	            }
	        }
		
		
		
		
	}

}
