
public class BankTransactionsystem {

   
    public static void main(String[] args) {
       
        BankAccount account1 = new BankAccount("Account1", 1000);
        BankAccount account2 = new BankAccount("Account2", 500);

        
        Thread t1 = new Thread(() -> {
            synchronized (account1) {  // Lock account1 first
                System.out.println("Thread 1 locked " + account1.getAccountNumber());
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
                synchronized (account2) {  // Lock account2
                    System.out.println("Thread 1 locked " + account2.getAccountNumber());
                    account1.transfer(account2, 200);  // Transfer from account1 to account2
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (account1) {  // Lock account1 first
                System.out.println("Thread 2 locked " + account1.getAccountNumber());
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
                synchronized (account2) {  // Lock account2
                    System.out.println("Thread 2 locked " + account2.getAccountNumber());
                    account2.transfer(account1, 100);  // Transfer from account2 to account1
                }
            }
        });

        
        t1.start();
        t2.start();

        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       
        System.out.println("Final balance of " + account1.getAccountNumber() + ": " + account1.getBalance());
        System.out.println("Final balance of " + account2.getAccountNumber() + ": " + account2.getBalance());
    }
}
