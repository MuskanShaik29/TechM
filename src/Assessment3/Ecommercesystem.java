package Assessment3;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Scanner;
	class OutOfStockException extends Exception {
	    public OutOfStockException(String message) {
	        super(message);
	    }
	}
	class ProductNotFoundException extends Exception {
	    public ProductNotFoundException(String message) {
	        super(message);
	    }
	}
	public class Ecommercesystem {
	    private static final Map<String, Integer> inventory = new HashMap<>();

	    static {
	        inventory.put("Laptop", 5);
	        inventory.put("Smartphone", 10);
	        inventory.put("Headphones", 0); 
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        try {
	            System.out.print("Enter product name: ");
	            String product = scanner.nextLine().trim();

	            System.out.print("Enter quantity: ");
	            int quantity = Integer.parseInt(scanner.nextLine().trim());
	            placeOrder(product, quantity);

	            System.out.println("Order placed successfully for " + quantity + " " + product + "(s).");

	        } catch (NumberFormatException | OutOfStockException | ProductNotFoundException e) {
	            System.out.println("Error: " + e.getMessage());
	        } finally {
	            scanner.close();
	        }
	    }

	    public static void placeOrder(String product, int quantity) throws ProductNotFoundException, OutOfStockException {
	        if (!inventory.containsKey(product)) {
	            throw new ProductNotFoundException("Product '" + product + "' not found.");
	        }
	        int availableStock = inventory.get(product);
	        if (availableStock == 0) {
	            throw new OutOfStockException("Product '" + product + "' is out of stock.");
	        }

	        if (quantity > availableStock) {
	            throw new OutOfStockException("Only " + availableStock + " units available for '" + product + "'.");
	        }
	        inventory.put(product, availableStock - quantity);
	    }
	}
