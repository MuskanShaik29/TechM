package Assessment10;
	import java.util.*;

	public class Gameofthrones {
	    
	    public static String canFormPalindrome(String s) {
	        int[] charCounts = new int[26]; // Array to store character counts
	        
	        // Count occurrences of each character
	        for (char c : s.toCharArray()) {
	            charCounts[c - 'a']++;
	        }
	        
	        // Count characters with odd frequencies
	        int oddCount = 0;
	        for (int count : charCounts) {
	            if (count % 2 != 0) {
	                oddCount++;
	            }
	        }
	        
	        // A string can be rearranged into a palindrome if oddCount <= 1
	        return (oddCount <= 1) ? "YES" : "NO";
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter string: ");
	        String input = scanner.nextLine().toLowerCase(); // Convert to lowercase for case insensitivity
	        System.out.println(canFormPalindrome(input));
	        scanner.close();
	    }
	}
