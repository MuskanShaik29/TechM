package Assessment3;
import java.util.Scanner;

//Custom Checked Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
 public InsufficientBalanceException(String message) {
     super(message);
 }
}

//Custom Unchecked Exception for Invalid Amount
class InvalidAmountException extends RuntimeException {
 public InvalidAmountException(String message) {
     super(message);
 }
}

//BankAccount Class
class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     if (initialBalance < 0) {
         throw new InvalidAmountException("Initial balance cannot be negative.");
     }
     this.balance = initialBalance;
 }

 // Deposit Money (Unchecked Exception for invalid input)
 public void deposit(double amount) {
     if (amount <= 0) {
         throw new InvalidAmountException("Deposit amount must be greater than zero.");
     }
     balance += amount;
     System.out.println("Deposited: $" + amount + ". New Balance: $" + balance);
 }

 // Withdraw Money (Checked Exception for insufficient funds)
 public void withdraw(double amount) throws InsufficientBalanceException {
     if (amount <= 0) {
         throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
     }
     if (amount > balance) {
         throw new InsufficientBalanceException("Insufficient funds! Available Balance: $" + balance);
     }
     balance -= amount;
     System.out.println("Withdrawn: $" + amount + ". New Balance: $" + balance);
 }

 // Display Balance
 public void showBalance() {
     System.out.println("Current Balance: $" + balance);
 }
}

//Main Class for Banking System
public class AdvancedBankingSystem {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     try {
         // Creating a new account with an initial balance
         System.out.print("Enter Initial Balance: ");
         double initialBalance = scanner.nextDouble();
         BankAccount account = new BankAccount(initialBalance);
         account.showBalance();

         // Banking Operations
         while (true) {
             System.out.println("\nChoose an operation: \n1. Deposit \n2. Withdraw \n3. Check Balance \n4. Exit");
             System.out.print("Enter choice: ");
             int choice = scanner.nextInt();

             switch (choice) {
                 case 1:
                     System.out.print("Enter deposit amount: ");
                     double depositAmount = scanner.nextDouble();
                     account.deposit(depositAmount);
                     break;
                 case 2:
                     System.out.print("Enter withdrawal amount: ");
                     double withdrawAmount = scanner.nextDouble();
                     try {
                         account.withdraw(withdrawAmount);
                     } catch (InsufficientBalanceException e) {
                         System.out.println("Error: " + e.getMessage());
                     }
                     break;
                 case 3:
                     account.showBalance();
                     break;
                 case 4:
                     System.out.println("Exiting Banking System. Thank you!");
                     scanner.close();
                     return;
                 default:
                     System.out.println("Invalid choice! Please try again.");
             }
         }
     } catch (InvalidAmountException e) {
         System.out.println("Invalid Amount Error: " + e.getMessage());
     } finally {
         scanner.close();
     }
 }
}
