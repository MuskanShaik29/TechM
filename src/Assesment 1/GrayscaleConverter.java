import java.util.Scanner;
public class GrayscaleConverter {
        public static int toGrayscale(int red, int green, int blue) {
            
            int grayscale = (int)((red * 77 + green * 150 + blue * 29) >> 8);
            return grayscale;
        }
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
    
           
            System.out.print("Enter Red (0-255): ");
            int red = sc.nextInt();
            System.out.print("Enter Green (0-255): ");
            int green = sc.nextInt();
            System.out.print("Enter Blue (0-255): ");
            int blue = sc.nextInt();
    
            int grayscale = toGrayscale(red, green, blue);
            System.out.println("Grayscale Value: " + grayscale);
    
            sc.close();
        }
    }
    
    

