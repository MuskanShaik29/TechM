package Assessment10;
import java.util.ArrayList;
public class Superiorelements {
	    public static ArrayList<Integer> findLeaders(int[] arr) {
	        ArrayList<Integer> leaders = new ArrayList<>();
	        int max = arr[arr.length - 1];
	        leaders.add(max);

	        for (int i = arr.length - 2; i >= 0; i--) {
	            if (arr[i] > max) {
	                max = arr[i];
	                leaders.add(max);
	            }
	        }
	        return leaders;
	    }

	    public static void main(String[] args) {
	        int[] arr = {16, 17, 4, 3, 5, 2};
	        System.out.println("Leader Elements: " + findLeaders(arr)); // Output: [2, 5, 17]
	    }
	}
