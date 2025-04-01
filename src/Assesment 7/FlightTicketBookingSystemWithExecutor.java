import java.util.concurrent.*;
import java.util.List;    
import java.util.ArrayList;  

class FlightTicketBookingSystem {
    private static int availableSeats = 10; 

   
    public static String bookTicket(String customerName) {
        synchronized (FlightTicketBookingSystem.class) {
            if (availableSeats > 0) {
                availableSeats--; 
                return "Booking successful for " + customerName + ". Seats left: " + availableSeats;
            } else {
                return "Booking failed for " + customerName + ". No seats available.";
            }
        }
    }
}

class BookingTask implements Callable<String> {
    private String customerName;

    
    public BookingTask(String customerName) {
        this.customerName = customerName;
    }

    
    @Override
    public String call() {
        return FlightTicketBookingSystem.bookTicket(customerName);
    }
}

public class FlightTicketBookingSystemWithExecutor {
    public static void main(String[] args) {
        
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        
        
        List<Future<String>> futures = new ArrayList<>();  

        
        futures.add(executorService.submit(new BookingTask("Customer 1")));
        futures.add(executorService.submit(new BookingTask("Customer 2")));
        futures.add(executorService.submit(new BookingTask("Customer 3")));
        futures.add(executorService.submit(new BookingTask("Customer 4")));
        futures.add(executorService.submit(new BookingTask("Customer 5")));
        futures.add(executorService.submit(new BookingTask("Customer 6"))); 

        
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get()); 
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        
        executorService.shutdown();
    }
}
