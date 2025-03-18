package com.traing.bank;

import java.util.Scanner;

public class SavingAccount {
	
	private double minBalance;
    private double roi; 

	
    private int accountNumber;
    private String name;
//    private double roi; 
    private double amount;

    
    public SavingAccount(int accountNumber, String name, double roi, double amount) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.roi = roi;
        this.amount = amount;
    }
    
    
    public double calculate() {
        return amount + (amount * roi / 100);
    }
    
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Rate of Interest: " + roi + "%");
        System.out.println("Initial Amount: " + amount);
        System.out.println("Total Amount after One Year: " + calculate());
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create a class name saving account with accountNumber , name , ROI and amount 
		// create a method calculate inside this and return the total amount after one year

//		Scanner sc = new Scanner (System.in);
//		System.out.println("enter account number");
//		int acctNumber = sc.nextInt();
//		
//		System.out.println("enter name ");
//		String name = sc.next();
//		
//		System.out.println("enter rate of interest");
//		double roi = sc.nextDouble();
//		
//		System.out.println("enter amount");
//		double amount = sc.nextDouble();
	
		
	        // Creating 4 SavingAccount objects
	        SavingAccount account1 = new SavingAccount(101, "ghaith", 5.0, 10000);
	        SavingAccount account2 = new SavingAccount(102, "hassan", 4.5, 15000);
	        SavingAccount account3 = new SavingAccount(103, "ali", 6.0, 12000);
	        SavingAccount account4 = new SavingAccount(104, "ghazi", 5.5, 13000);
	        
	        
	        SavingAccount[] accounts = {account1, account2, account3, account4};

	        SavingAccount highestAccount = accounts[0];
	        
	        for (SavingAccount account : accounts) {
	            if (account.calculate() > highestAccount.calculate()) {
	                highestAccount = account;}} 
		
//        SavingAccount account = new SavingAccount(acctNumber, name, roi, amount);
        
        
        
//        account.displayAccountDetails();
	      highestAccount.displayAccountDetails();

	}

}
