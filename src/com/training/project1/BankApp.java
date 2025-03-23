package com.training.project1;

import java.util.Scanner;

public class BankApp {
    private static Scanner scanner = new Scanner(System.in);
    private static BankService bankService;

    public static void main(String[] args) {
        try {
            bankService = new BankService();

            while (true) {
                System.out.println("\n- Bank Application Menu:");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Transfer Funds");
                System.out.println("5. Check Balance");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: createAccount(); break;
                    case 2: depositMoney(); break;
                    case 3: withdrawMoney(); break;
                    case 4: transferFunds(); break;
                    case 5: checkBalance(); break;
                    case 6: System.exit(0);
                    default: System.out.println("Invalid choice, try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createAccount() {
        System.out.print("Enter your name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit: ");
        double balance = scanner.nextDouble();
        bankService.createAccount(name, balance);
    }

    private static void depositMoney() {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        bankService.depositMoney(accountId, amount);
    }

    private static void withdrawMoney() {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        bankService.withdrawMoney(accountId, amount);
    }

    private static void transferFunds() {
        System.out.print("Enter sender account ID: ");
        int senderId = scanner.nextInt();
        System.out.print("Enter receiver account ID: ");
        int receiverId = scanner.nextInt();
        System.out.print("Enter transfer amount: ");
        double amount = scanner.nextDouble();
        bankService.transferFunds(senderId, receiverId, amount);
    }

    private static void checkBalance() {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        bankService.checkBalance(accountId);
    }
}

