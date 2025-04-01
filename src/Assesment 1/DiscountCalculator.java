import java.util.Scanner;
public class DiscountCalculator {
    public static double calculateFinalPrice(double cartValue) {
            double discount = 0;
    
            
            if (cartValue > 500) {
                discount = 0.20; 
            } else if (cartValue >= 100) {
                discount = 0.10;
            }
    
            return cartValue - (cartValue * discount);
        }
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
      
            System.out.print("Enter cart value: $");
            double cartValue = sc.nextDouble();
    
            
            double finalPrice = calculateFinalPrice(cartValue);
            System.out.println("Final Price after Discount: $" + finalPrice);
    
            sc.close();
        }
    }
    
    

