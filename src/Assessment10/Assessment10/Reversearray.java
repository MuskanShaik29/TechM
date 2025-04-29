package Assessment10;
	import java.util.Arrays;

	public class Reversearray {
	    
	    // Method 1: Iterative approach (Two-pointer method) - O(n) time complexity
	    public static void reverseIterative(int[] arr) {
	        int left = 0, right = arr.length - 1;
	        while (left < right) {
	            int temp = arr[left];
	            arr[left] = arr[right];
	            arr[right] = temp;
	            left++;
	            right--;
	        }
	    }

	    // Method 2: Recursive approach
	    public static void reverseRecursive(int[] arr, int left, int right) {
	        if (left >= right) return;  // Base condition
	        int temp = arr[left];
	        arr[left] = arr[right];
	        arr[right] = temp;
	        reverseRecursive(arr, left + 1, right - 1);
	    }

	    public static void main(String[] args) {
	        int[] arr1 = {1, 2, 3, 4, 5};
	        int[] arr2 = {10, 20, 30, 40, 50};

	        // Using Iterative Method
	        reverseIterative(arr1);
	        System.out.println("Reversed Array (Iterative): " + Arrays.toString(arr1));

	        // Using Recursive Method
	        reverseRecursive(arr2, 0, arr2.length - 1);
	        System.out.println("Reversed Array (Recursive): " + Arrays.toString(arr2));
	    }
	}