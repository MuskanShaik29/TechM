class OrderProcessingSystem {
    private static int availableStock = 10; 

    
    public synchronized static void processOrder(String customerName) {
        if (availableStock > 0) {
            System.out.println("Order for " + customerName + " is being processed...");
            availableStock--;  
            System.out.println("Order processed for " + customerName + ". Stock left: " + availableStock);
        } else {
            System.out.println("Sorry " + customerName + ", no stock available.");
        }
    }
}

class CustomerOrderThread extends Thread {
    private String customerName;

    
    public CustomerOrderThread(String customerName) {
        this.customerName = customerName;
    }

    
    @Override
    public void run() {
        OrderProcessingSystem.processOrder(customerName);
    }
}

public class MultiThreadedOrderProcessing {
    public static void main(String[] args) {
        
        Thread customer1 = new CustomerOrderThread("Customer 1");
        Thread customer2 = new CustomerOrderThread("Customer 2");
        Thread customer3 = new CustomerOrderThread("Customer 3");
        Thread customer4 = new CustomerOrderThread("Customer 4");
        Thread customer5 = new CustomerOrderThread("Customer 5");

        
        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();

        try {
           
            customer1.join();
            customer2.join();
            customer3.join();
            customer4.join();
            customer5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All orders processed.");
    }
}