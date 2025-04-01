import java.util.concurrent.*;

public class CountdownTimer {

    public static void main(String[] args) throws InterruptedException {
       
        int numberOfTasks = 5;

        
        CountDownLatch latch = new CountDownLatch(numberOfTasks);

       
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfTasks);

        
        for (int i = 1; i <= numberOfTasks; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                try {
                   
                    System.out.println("Task " + taskId + " is starting.");
                    Thread.sleep(2000);  // Simulate task processing time (2 seconds)
                    System.out.println("Task " + taskId + " is completed.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    
                    latch.countDown();
                }
            });
        }

        
        latch.await();

        
        System.out.println("All tasks are completed. Proceeding to the next step...");

        
        executorService.shutdown();
    }
}
