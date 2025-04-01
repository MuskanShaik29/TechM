package Assessment3;
	import java.util.Random;
	class NegativeNumberException extends Exception {
	    public NegativeNumberException(String message) {
	        super(message);
	    }
	}
	class NumberGenerator extends Thread {
	    private final int[] numbers;

	    public NumberGenerator(int[] numbers) {
	        this.numbers = numbers;
	    }

	    @Override
	    public void run() {
	        Random random = new Random();
	        try {
	            System.out.println("Generating numbers...");
	            for (int i = 0; i < numbers.length; i++) {
	                numbers[i] = random.nextInt(50) - 25; 
	                System.out.println("Generated: " + numbers[i]);
	            }
	        } catch (Exception e) {
	            System.out.println("Error in NumberGenerator: " + e.getMessage());
	        } finally {
	            System.out.println("NumberGenerator Thread Finished.");
	        }
	    }
	}
	class SquareRootCalculator extends Thread {
	    private final int[] numbers;

	    public SquareRootCalculator(int[] numbers) {
	        this.numbers = numbers;
	    }

	    @Override
	    public void run() {
	        try {
	            System.out.println("Calculating square roots...");
	            for (int number : numbers) {
	                if (number < 0) {
	                    throw new NegativeNumberException("Negative number encountered: " + number);
	                }
	                System.out.println("Square root of " + number + " is " + Math.sqrt(number));
	            }
	        } catch (NegativeNumberException e) {
	            System.out.println("Error: " + e.getMessage());
	        } catch (Exception e) {
	            System.out.println("Unexpected Error: " + e.getMessage());
	        } finally {
	            System.out.println("SquareRootCalculator Thread Finished.");
	        }
	    }
	}
	public class Multithreaded {
	    public static void main(String[] args) {
	        int[] numbers = new int[5]; 
	        NumberGenerator generator = new NumberGenerator(numbers);
	        SquareRootCalculator calculator = new SquareRootCalculator(numbers);

	        try {
	            generator.start();
	            generator.join(); 

	            calculator.start();
	            calculator.join(); 
	        } catch (InterruptedException e) {
	            System.out.println("Thread interrupted: " + e.getMessage());
	        } finally {
	            System.out.println("All threads executed successfully.");
	        }
	    }
	}
