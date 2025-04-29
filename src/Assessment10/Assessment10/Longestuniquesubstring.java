package Assessment10;
	import java.util.*;

	public class Longestuniquesubstring {

	    public static int lengthOfLongestSubstring(String s) {
	        Set<Character> charSet = new HashSet<>();
	        int left = 0, maxLength = 0;

	        for (int right = 0; right < s.length(); right++) {
	            while (charSet.contains(s.charAt(right))) {
	                charSet.remove(s.charAt(left));
	                left++;
	            }
	            charSet.add(s.charAt(right));
	            maxLength = Math.max(maxLength, right - left + 1);
	        }
	        return maxLength;
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter string: ");
	        String input = scanner.nextLine();
	        System.out.println("Longest Unique Substring Length: " + lengthOfLongestSubstring(input));
	        scanner.close();
	    }
	}
