package Assessment10;
	import java.util.Arrays;

	public class Sortcolors {

	    public static void sortColors(int[] arr) {
	        int low = 0, mid = 0, high = arr.length - 1;

	        while (mid <= high) {
	            if (arr[mid] == 0) {
	                // Swap arr[low] and arr[mid], move both pointers
	                int temp = arr[low];
	                arr[low] = arr[mid];
	                arr[mid] = temp;
	                low++;
	                mid++;
	            } else if (arr[mid] == 1) {
	                // Mid is correct, just move mid pointer
	                mid++;
	            } else { // arr[mid] == 2
	                // Swap arr[mid] and arr[high], move high pointer
	                int temp = arr[mid];
	                arr[mid] = arr[high];
	                arr[high] = temp;
	                high--;
	            }
	        }
	    }

	    public static void main(String[] args) {
	        int[] arr = {2, 0, 2, 1, 1, 0, 1, 2, 0, 1};
	        
	        sortColors(arr);
	        
	        System.out.println("Sorted Colors: " + Arrays.toString(arr));
	    }
	}
