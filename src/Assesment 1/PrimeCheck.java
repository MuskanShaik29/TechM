import java.util.Scanner;
public class PrimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        boolean isPrime = isPrime(num);
        if (isPrime)
            System.out.println("Yes, " + num + " is a prime number.");
        else
            System.out.println("No, " + num + " is not a prime number.");
            sc.close();
        }
        public static boolean isPrime(int num) {
            if (num <= 1) return false;
            if (num == 2) return true; 
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    
    

