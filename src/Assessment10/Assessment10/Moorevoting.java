package Assessment10;
	import java.util.Arrays;

	public class Moorevoting {

	    // Function to find the majority element
	    public static int findMajorityElement(int[] arr) {
	        int candidate = findCandidate(arr);
	        
	        // Verify if the candidate is actually a majority element
	        if (isMajority(arr, candidate)) {
	            return candidate;
	        }
	        return -1; // No majority element found
	    }

	    // Step 1: Find a potential candidate using Moore's Voting Algorithm
	    private static int findCandidate(int[] arr) {
	        int count = 0, candidate = -1;
	        
	        for (int num : arr) {
	            if (count == 0) {
	                candidate = num;
	            }
	            count += (num == candidate) ? 1 : -1;
	        }
	        return candidate;
	    }

	    // Step 2: Verify if the candidate is actually the majority element
	    private static boolean isMajority(int[] arr, int candidate) {
	        int count = 0;
	        for (int num : arr) {
	            if (num == candidate) {
	                count++;
	            }
	        }
	        return count > arr.length / 2;
	    }

	    public static void main(String[] args) {
	        int[] arr = {3, 3, 4, 2, 3, 3, 3, 1};
	        
	        int result = findMajorityElement(arr);
	        
	        if (result != -1) {
	            System.out.println("Majority Element: " + result);
	        } else {
	            System.out.println("No Majority Element Found");
	        }
	    }
	}