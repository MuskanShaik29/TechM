import java.util.Arrays;
import java.util.Comparator;

public class AnonymousClassSorting {
    public static void main(String[] args) {
        Integer[] numbers = {5, 3, 8, 1, 2};

        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a; // Sorting in descending order
            }
        });

        System.out.println("Sorted Array: " + Arrays.toString(numbers));
    }
}
