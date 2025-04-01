import java.util.ArrayList;
import java.util.List;

public class MemoryLeakDetector {
    private static List<Object> memoryLeakList = new ArrayList<>();

    public static void main(String[] args) {
        
        for (int i = 0; i < 100000; i++) {
            memoryLeakList.add(new Object());
            
            
            if (i % 10000 == 0) {
                System.out.println("Objects in memoryLeakList: " + memoryLeakList.size());
            }
        }
        
        
        System.out.println("Memory leak is happening, program may crash soon.");
    }
}
