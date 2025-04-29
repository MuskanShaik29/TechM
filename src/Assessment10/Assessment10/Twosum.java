package Assessment10;
	import java.util.*;

	public class Twosum {
	    
	    // Approach 1: Using HashMap (O(n) time, O(n) space)
	    public static int[] findPairWithSumHashMap(int[] arr, int target) {
	        Map<Integer, Integer> numMap = new HashMap<>();

	        for (int i = 0; i < arr.length; i++) {
	            int complement = target - arr[i];

	            if (numMap.containsKey(complement)) {
	                return new int[]{numMap.get(complement), i}; // Return indices
	            }
	            numMap.put(arr[i], i);
	        }
	        return new int[]{-1, -1}; // No pair found
	    }

	    // Approach 2: Using Two-Pointer Technique (O(n log n) due to sorting)
	    public static int[] findPairWithSumTwoPointer(int[] arr, int target) {
	        Arrays.sort(arr); // Sort array

	        int left = 0, right = arr.length - 1;
	        
	        while (left < right) {
	            int sum = arr[left] + arr[right];

	            if (sum == target) {
	                return new int[]{arr[left], arr[right]}; // Return values
	            } else if (sum < target) {
	                left++;
	            } else {
	                right--;
	            }
	        }
	        return new int[]{-1, -1}; // No pair found
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Enter array size: ");
	        int n = scanner.nextInt();
	        int[] arr = new int[n];

	        System.out.println("Enter array elements:");
	        for (int i = 0; i < n; i++) {
	            arr[i] = scanner.nextInt();
	        }

	        System.out.print("Enter target sum: ");
	        int target = scanner.nextInt();
	        
	        System.out.print("Choose method (1: HashMap, 2: Two-Pointer for sorted array): ");
	        int choice = scanner.nextInt();
	        
	        int[] result;
	        
	        if (choice == 1) {
	            result = findPairWithSumHashMap(arr, target);
	            if (result[0] != -1) {
	                System.out.println("Pair found at indices: " + result[0] + " and " + result[1]);
	            } else {
	                System.out.println("No pair found");
	            }
	        } else {
	            result = findPairWithSumTwoPointer(arr, target);
	            if (result[0] != -1) {
	                System.out.println("Pair found: " + result[0] + " and " + result[1]);
	            } else {
	                System.out.println("No pair found");
	            }
	        }
	        
	        scanner.close();
	    }
	}

