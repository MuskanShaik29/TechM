import java.util.Scanner;
public class FibonacciDoWhile {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number of Fibonacci terms: ");
            int n = sc.nextInt();
    
            int a = 0, b = 1, count = 0;
            
            do {
                System.out.print(a + " ");
                int next = a + b;
                a = b;
                b = next;
                count++;
            } while (count < n);
    
            sc.close();
        }
    }
    
    

