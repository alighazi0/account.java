package com.training.project1;

import java.sql.*;

public class BankService {
    private Connection conn;

    public BankService() throws SQLException {
        conn = DatabaseConnection.getConnection();
    }

    // Method to create an account
    public void createAccount(String name, double balance) {
        try {
            String sql = "INSERT INTO bank_account (name, balance) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setDouble(2, balance);
            stmt.executeUpdate();
            System.out.println("Account created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to deposit money
    public void depositMoney(int accountId, double amount) {
        try {
            String sql = "UPDATE bank_account SET balance = balance + ? WHERE account_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, amount);
            stmt.setInt(2, accountId);
            int rows = stmt.executeUpdate();

            if (rows > 0) System.out.println("Deposit successful!");
            else System.out.println("Account not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to withdraw money
    public void withdrawMoney(int accountId, double amount) {
        try {
            String checkSql = "SELECT balance FROM bank_account WHERE account_id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setInt(1, accountId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");
                if (amount > balance) {
                    System.out.println("no enough balance");
                } else {
                    String sql = "UPDATE bank_account SET balance = balance - ? WHERE account_id = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setDouble(1, amount);
                    stmt.setInt(2, accountId);
                    stmt.executeUpdate();
                    System.out.println("Withdrawal successful!");
                }
            } else {
                System.out.println("Account not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to transfer funds
    public void transferFunds(int senderId, int receiverId, double amount) {
        try {
            conn.setAutoCommit(false);

            String checkSender = "SELECT balance FROM bank_account WHERE account_id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSender);
            checkStmt.setInt(1, senderId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                double senderBalance = rs.getDouble("balance");
                if (amount > senderBalance) {
                    System.out.println("no enough balance.");
                } else {
                    String debitSql = "UPDATE bank_account SET balance = balance - ? WHERE account_id = ?";
                    PreparedStatement debitStmt = conn.prepareStatement(debitSql);
                    debitStmt.setDouble(1, amount);
                    debitStmt.setInt(2, senderId);
                    debitStmt.executeUpdate();

                    String creditSql = "UPDATE bank_account SET balance = balance + ? WHERE account_id = ?";
                    PreparedStatement creditStmt = conn.prepareStatement(creditSql);
                    creditStmt.setDouble(1, amount);
                    creditStmt.setInt(2, receiverId);
                    creditStmt.executeUpdate();

                    conn.commit();
                    System.out.println("Transfer successful!");
                }
            } else {
                System.out.println("Sender account not found.");
            }
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to check balance
    public void checkBalance(int accountId) {
        try {
            String sql = "SELECT balance FROM bank_account WHERE account_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Current Balance: " + rs.getDouble("balance"));
            } else {
                System.out.println("Account not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}