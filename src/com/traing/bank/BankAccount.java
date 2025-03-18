package com.traing.bank;

public class BankAccount {
	
	String acccountHolderName;
	void display() {
		int age =21; // local varaible 
		acccountHolderName = "David";
	}
	
	public static void main(String[] args) {// protected // private // default 
//		// TODO Auto-generated method stub
//		System.out.println("welcom to my bank");
//		System.out.println("First Agument : " +args[0]);
//		
//		
//		
//		BankAccount account1 = new BankAccount();
//		account1.acccountHolderName = "David";
//		
//		
//		short s = 10;
//		int i = 5;
//		i = s;
//		s=(short)i;
//		
//		System.out.println(i);

        // Creating an account object
        Account myAccount = new Account(123456, "John Doe", 5000.0);

        // Displaying account details
        myAccount.displayAccountDetails();

        // Performing transactions
        myAccount.deposit(2000);
        myAccount.withdraw(1000);
        myAccount.checkBalance();
		
		
	}

}



