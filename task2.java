/* TASK 2

1.Create a class to represent the ATM machine.

2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
checking the balance.

3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
checkBalance().

4. Create a class to represent the user's bank account, which stores the account balance.

5. Connect the ATM class with the user's bank account class to access and modify the account
balance.

6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).

7. Display appropriate messages to the user based on their chosen options and the success or failure
of their transactions.

ATM INTERFACE */

import java.util.Scanner;

// BankAccount class to represent the user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize the balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit an amount into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. You deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw an amount from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. You withdrew: " + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance for this withdrawal.");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
    }

    // Method to check the current balance
    public double checkBalance() {
        return balance;
    }
}

// ATM class to handle the user interface and operations
class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor to initialize the ATM with a BankAccount
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu and handle user input
    public void showMenu() {
        int option;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (option != 4);
    }

    // Method to check balance
    private void checkBalance() {
        System.out.println("Your current balance is: " + account.checkBalance());
    }

    // Method to deposit money
    private void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    // Method to withdraw money
    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}

// Main class to run the ATM program
public class ATMSystem {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount myAccount = new BankAccount(1000.00);

        // Create an ATM object and pass the bank account to it
        ATM myATM = new ATM(myAccount);

        // Show the ATM menu and allow the user to perform operations
        myATM.showMenu();
    }
}

/*
Output : 

ATM Menu:
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option: 2
Enter the amount to deposit: 77000
Deposit successful. You deposited: 77000.0

ATM Menu:
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option: 1
Your current balance is: 78000.0

ATM Menu:
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option: 3
Enter the amount to withdraw: 2000
Withdrawal successful. You withdrew: 2000.0

ATM Menu:
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option: 1
Your current balance is: 76000.0

ATM Menu:
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option: 5
Invalid option. Please choose again.

ATM Menu:
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option: 3
Enter the amount to withdraw: 76000
Withdrawal successful. You withdrew: 76000.0

ATM Menu:
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option: 3
Enter the amount to withdraw: 500
Insufficient balance for this withdrawal.

ATM Menu:
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option: 4
Thank you for using the ATM.

*/

