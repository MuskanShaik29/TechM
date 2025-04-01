
public class BankAccount {
    private String accountNumber;
    private int balance;

    
    public BankAccount(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    
    public String getAccountNumber() {
        return accountNumber;
    }

    
    public int getBalance() {
        return balance;
    }

   
    public void deposit(int amount) {
        balance += amount;
    }

    
    public void withdraw(int amount) {
        balance -= amount;
    }

    
    public synchronized void transfer(BankAccount toAccount, int amount) {
        if (this.balance >= amount) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transferred " + amount + " from " + this.getAccountNumber() + " to " + toAccount.getAccountNumber());
        } else {
            System.out.println("Insufficient balance in " + this.getAccountNumber() + " for transfer");
        }
    }
}
