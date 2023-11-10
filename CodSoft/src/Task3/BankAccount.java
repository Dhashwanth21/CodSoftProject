package Task3;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void withdraw(double amount) {
        if (bankAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: $" + bankAccount.getBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient funds.");
        }
    }

    public void deposit(double amount) {
        bankAccount.deposit(amount);
        System.out.println("Deposit successful. New balance: $" + bankAccount.getBalance());
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + bankAccount.getBalance());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount bankAccount = new BankAccount(1000);
        ATM atm = new ATM(bankAccount);

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = getValidInput("Enter your choice (1-4): ", input -> input.matches("[1-4]"));

            switch (choice) {
                case 1:
                    double withdrawAmount = getValidDoubleInput("Enter withdrawal amount: ");
                    atm.withdraw(withdrawAmount);
                    break;

                case 2:
                    double depositAmount = getValidDoubleInput("Enter deposit amount: ");
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Exiting.");
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }

    private static int getValidInput(String prompt, java.util.function.Predicate<String> validator) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (validator.test(input)) {
                return Integer.parseInt(input);
            }
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static double getValidDoubleInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            }
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
        }
    }
}



