package in.srikar;

import java.util.Scanner;

public class BankySimulation {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Banky Simulation!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Exit");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter Account ID:");
                    String accountId = scanner.nextLine();
                    System.out.println("Enter Account Name:");
                    String accountName = scanner.nextLine();
                    System.out.println("Enter Initial Balance:");
                    double initialBalance = 0;
                    try {
                        initialBalance = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number for initial balance.");
                        continue;
                    }
                    bank.createAccount(accountId, accountName, initialBalance);
                    break;
                case 2:
                    System.out.println("Enter Account ID:");
                    String depositAccountId = scanner.nextLine();
                    System.out.println("Enter Amount to Deposit:");
                    double depositAmount = scanner.nextDouble();
                    Account depositAccount = bank.getAccount(depositAccountId);
                    if (depositAccount != null) {
                        depositAccount.deposit(depositAmount);
                        System.out.println("Deposit successful. Updated balance: " + depositAccount.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter Account ID:");
                    String withdrawAccountId = scanner.nextLine();
                    System.out.println("Enter Amount to Withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    Account withdrawAccount = bank.getAccount(withdrawAccountId);
                    if (withdrawAccount != null) {
                        if (withdrawAccount.withdraw(withdrawAmount)) {
                            System.out.println("Withdrawal successful. Updated balance: " + withdrawAccount.getBalance());
                        } else {
                            System.out.println("Insufficient funds.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter Source Account ID:");
                    String sourceAccountId = scanner.nextLine();
                    System.out.println("Enter Destination Account ID:");
                    String destAccountId = scanner.nextLine();
                    System.out.println("Enter Amount to Transfer:");
                    double transferAmount = scanner.nextDouble();
                    Account sourceAccount = bank.getAccount(sourceAccountId);
                    Account destAccount = bank.getAccount(destAccountId);
                    if (sourceAccount != null && destAccount != null) {
                        sourceAccount.transfer(destAccount, transferAmount);
                        System.out.println("Transfer successful.");
                    } else {
                        System.out.println("One or both accounts not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting Banky Simulation. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}

