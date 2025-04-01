package Assessment3;
	import java.io.*;

	// Custom Checked Exception for Empty File
	class EmptyFileException extends Exception {
	    public EmptyFileException(String message) {
	        super(message);
	    }
	}

	// FileProcessor Class
	class FileProcessor {
	    
	    // Method to Read Integers from a File and Calculate Sum
	    public static int processFile(String filePath) throws EmptyFileException {
	        File file = new File(filePath);
	        int sum = 0;
	        boolean isEmpty = true;

	        // Try-with-resources ensures proper resource management
	        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	            String line;
	            
	            while ((line = reader.readLine()) != null) {
	                line = line.trim();
	                if (!line.isEmpty()) {
	                    try {
	                        int number = Integer.parseInt(line);
	                        sum += number;
	                        isEmpty = false;
	                    } catch (NumberFormatException e) {
	                        System.out.println("Warning: Invalid number format in line - \"" + line + "\". Skipping.");
	                    }
	                }
	            }
	            
	            if (isEmpty) {
	                throw new EmptyFileException("The file is empty! Please provide valid data.");
	            }

	        } catch (FileNotFoundException e) {
	            System.out.println("Error: File not found - " + filePath);
	            return -1;
	        } catch (IOException e) {
	            System.out.println("Error reading the file: " + e.getMessage());
	            return -1;
	        }
	        
	        return sum;
	    }
	}

	// Main Class to Test File Processing
	public class FileProcessingSystem {
	    public static void main(String[] args) {
	        String filePath = "numbers.txt";  // Change this to your file path
	        
	        try {
	            int sum = FileProcessor.processFile(filePath);
	            if (sum != -1) {
	                System.out.println("Sum of numbers in the file: " + sum);
	            }
	        } catch (EmptyFileException e) {
	            System.out.println("Custom Exception Caught: " + e.getMessage());
	        }
	    }
	}
