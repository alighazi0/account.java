package com.training.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private int id;
    private String name;
    private String email;

    private static ArrayList<Customer> customers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public void display() {
        System.out.println("Customer ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("----------------------");
    }
    
    

    public static void addCustomer() {
        System.out.print("Enter Customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        customers.add(new Customer(id, name, email));
        System.out.println("Customer added successfully!");
    }

    public static void updateCustomer() {
        System.out.print("Enter Customer ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Customer customer : customers) {
            if (customer.getId() == id) {
                System.out.print("Enter New Name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter New Email: ");
                String newEmail = scanner.nextLine();

                customer.setName(newName);
                customer.setEmail(newEmail);
                System.out.println("Customer details updated successfully!");
                return;
            }
        }
        System.out.println("Customer not found!");
    }

    
    
    public static void deleteCustomer() {
        System.out.print("Enter Customer ID to delete: ");
        int id = scanner.nextInt();

        boolean removed = customers.removeIf(customer -> customer.getId() == id);
        if (removed) {
            System.out.println("Customer deleted successfully!");
        } else {
            System.out.println("Customer not found!");
        }
    }
    
    

    public static void showCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found!");
            return;
        }

        System.out.println("Customer List:");
        for (Customer customer : customers) {
            customer.display();
        }
    }

    public static Scanner getScanner() {
        return scanner;
    }
}