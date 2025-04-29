package Assessment10;
	import java.util.Arrays;

	public class ReverseSubgroups {

	    public static void reverseInGroups(int[] arr, int k) {
	        int n = arr.length;

	        for (int i = 0; i < n; i += k) {
	            int left = i;
	            int right = Math.min(i + k - 1, n - 1); // Ensure we don't go out of bounds
	            reverseSubArray(arr, left, right);
	        }
	    }

	    private static void reverseSubArray(int[] arr, int left, int right) {
	        while (left < right) {
	            int temp = arr[left];
	            arr[left] = arr[right];
	            arr[right] = temp;
	            left++;
	            right--;
	        }
	    }

	    public static void main(String[] args) {
	        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Size 10 (n=10)
	        int k = 3; // k is not a multiple of n (10 % 3 ≠ 0)

	        reverseInGroups(arr, k);
	        System.out.println("Reversed Array in Groups: " + Arrays.toString(arr));
	    }
	}
