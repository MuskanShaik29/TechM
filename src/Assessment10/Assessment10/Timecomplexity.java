package Assessment10;
	import java.util.Arrays;

	public class Timecomplexity {
	    
	    // O(1) - Directly accessing an element in an array
	    public static int getElement(int[] arr, int index) {
	        return arr[index];
	    }

	    // O(log n) - Binary Search
	    public static int binarySearch(int[] arr, int target) {
	        int left = 0, right = arr.length - 1;
	        while (left <= right) {
	            int mid = left + (right - left) / 2;
	            if (arr[mid] == target) return mid;
	            if (arr[mid] < target) left = mid + 1;
	            else right = mid - 1;
	        }
	        return -1;
	    }

	    // O(n) - Finding Maximum Element
	    public static int findMax(int[] arr) {
	        int max = arr[0];
	        for (int num : arr) {
	            if (num > max) {
	                max = num;
	            }
	        }
	        return max;
	    }

	    // O(n log n) - Merge Sort
	    public static void mergeSort(int[] arr, int left, int right) {
	        if (left < right) {
	            int mid = left + (right - left) / 2;
	            mergeSort(arr, left, mid);
	            mergeSort(arr, mid + 1, right);
	            merge(arr, left, mid, right);
	        }
	    }

	    private static void merge(int[] arr, int left, int mid, int right) {
	        int n1 = mid - left + 1;
	        int n2 = right - mid;
	        int[] leftArr = new int[n1];
	        int[] rightArr = new int[n2];

	        System.arraycopy(arr, left, leftArr, 0, n1);
	        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

	        int i = 0, j = 0, k = left;
	        while (i < n1 && j < n2) {
	            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
	        }
	        while (i < n1) arr[k++] = leftArr[i++];
	        while (j < n2) arr[k++] = rightArr[j++];
	    }

	    // O(n²) - Bubble Sort
	    public static void bubbleSort(int[] arr) {
	        int n = arr.length;
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	                if (arr[j] > arr[j + 1]) {
	                    int temp = arr[j];
	                    arr[j] = arr[j + 1];
	                    arr[j + 1] = temp;
	                }
	            }
	        }
	    }

	    public static void main(String[] args) {
	        int[] arr = {12, 11, 13, 5, 6, 7};
	        int target = 13;
	        int index = 2;

	        // O(1) - Accessing an element
	        System.out.println("Element at index " + index + ": " + getElement(arr, index));

	        // O(log n) - Binary Search
	        Arrays.sort(arr); // Binary search needs a sorted array
	        System.out.println("Element " + target + " found at index: " + binarySearch(arr, target));

	        // O(n) - Finding Maximum Element
	        System.out.println("Maximum Element: " + findMax(arr));

	        // O(n log n) - Merge Sort
	        int[] mergeArr = {12, 11, 13, 5, 6, 7};
	        mergeSort(mergeArr, 0, mergeArr.length - 1);
	        System.out.println("Sorted Array (Merge Sort): " + Arrays.toString(mergeArr));

	        // O(n²) - Bubble Sort
	        int[] bubbleArr = {64, 34, 25, 12, 22, 11, 90};
	        bubbleSort(bubbleArr);
	        System.out.println("Sorted Array (Bubble Sort): " + Arrays.toString(bubbleArr));
	    }
	}
