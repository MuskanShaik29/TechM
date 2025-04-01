package Assessment3;
	import java.util.Random;
	import java.util.Scanner;
	class NetworkException extends Exception {
	    public NetworkException(String message) {
	        super(message);
	    }
	}
	class InvalidPINException extends Exception {
	    public InvalidPINException(String message) {
	        super(message);
	    }
	}

	class InsufficientFundsException extends Exception {
	    public InsufficientFundsException(String message) {
	        super(message);
	    }
	}
	class DailyLimitExceededException extends Exception {
	    public DailyLimitExceededException(String message) {
	        super(message);
	    }
	}
	public class ATMSimulation {
	    private static final int CORRECT_PIN = 1234;
	    private static final double ACCOUNT_BALANCE = 5000.0;
	    private static final double DAILY_LIMIT = 2000.0;

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        try {
	            checkNetwork(); 

	            try {
	                System.out.print("Enter your PIN: ");
	                int enteredPin = scanner.nextInt();

	                if (enteredPin != CORRECT_PIN) {
	                    throw new InvalidPINException("Incorrect PIN. Please try again.");
	                }
	                System.out.print("Enter withdrawal amount: ");
	                double withdrawalAmount = scanner.nextDouble();

	                if (withdrawalAmount > ACCOUNT_BALANCE) {
	                    throw new InsufficientFundsException("Insufficient balance. Your balance is: $" + ACCOUNT_BALANCE);
	                }

	                if (withdrawalAmount > DAILY_LIMIT) {
	                    throw new DailyLimitExceededException("Transaction failed! Daily limit exceeded. Max allowed: $" + DAILY_LIMIT);
	                }
	                System.out.println("Withdrawal successful! Amount withdrawn: $" + withdrawalAmount);
	                System.out.println("Remaining balance: $" + (ACCOUNT_BALANCE - withdrawalAmount));

	            } catch (InvalidPINException | InsufficientFundsException | DailyLimitExceededException e) {
	                System.out.println("Transaction Error: " + e.getMessage());
	            }

	        } catch (NetworkException e) {
	            System.out.println("Network Error: " + e.getMessage());
	        } finally {
	            scanner.close();
	            System.out.println("ATM session ended.");
	        }
	    }
	    private static void checkNetwork() throws NetworkException {
	        Random random = new Random();
	        if (random.nextBoolean()) { 
	            throw new NetworkException("Network connectivity issue. Please try again later.");
	        }
	    }
	}
