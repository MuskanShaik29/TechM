import java.io.*;

public class LargeFileProcessor {
    public static void main(String[] args) {
        String filePath = "largefile.txt";
        
        Thread fileThread = new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Processing: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        
        fileThread.start();
    }
}
