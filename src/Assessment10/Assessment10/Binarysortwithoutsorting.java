package Assessment10;
	import java.util.Arrays;

	public class Binarysortwithoutsorting {
	    
	    public static void sortBinaryArray(int[] arr) {
	        int countZero = 0;

	        // Count the number of 0s
	        for (int num : arr) {
	            if (num == 0) {
	                countZero++;
	            }
	        }

	        // Fill first `countZero` elements with 0 and the rest with 1
	        for (int i = 0; i < arr.length; i++) {
	            arr[i] = (i < countZero) ? 0 : 1;
	        }
	    }

	    public static void main(String[] args) {
	        int[] arr = {1, 0, 1, 0, 1, 0, 0, 1};
	        
	        sortBinaryArray(arr);
	        
	        System.out.println("Sorted Array: " + Arrays.toString(arr));
	    }
	}
