import java.util.Scanner;
public class MultiplicationTable {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            char choice;
    
            do {

                System.out.print("Enter a number for the multiplication table: ");
                int n = sc.nextInt();
    
                
                System.out.println("\nMultiplication Table of " + n + " (Using for loop):");
                for (int i = 1; i <= 10; i++) {
                    System.out.println(n + " x " + i + " = " + (n * i));
                }
    
            
                System.out.println("\nMultiplication Table in Reverse Order:");
                for (int i = 10; i >= 1; i--) {
                    System.out.println(n + " x " + i + " = " + (n * i));
                }
    
            
                System.out.print("\nEnter start value: ");
                int start = sc.nextInt();
                System.out.print("Enter end value: ");
                int end = sc.nextInt();
    
                System.out.println("\nMultiplication Table from " + start + " to " + end + " (Using while loop):");
                int i = start;
                while (i <= end) {
                    System.out.println(n + " x " + i + " = " + (n * i));
                    i++;
                }
    
             
                System.out.print("\nDo you want to generate another table? (y/n): ");
                choice = sc.next().charAt(0);
    
            } while (choice == 'y' || choice == 'Y'); // Continue if user enters 'y' or 'Y'
    
            sc.close();
            System.out.println("Program exited. Thank you!");
        }
    }
    
    

