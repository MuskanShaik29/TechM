import java.io.*;
import java.util.Scanner;

public class ChatLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "chatlog.txt";
        
        System.out.println("Enter messages (type 'exit' to stop):");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            while (true) {
                String message = scanner.nextLine();
                if (message.equalsIgnoreCase("exit")) break;
                writer.write(message);
                writer.newLine();
            }
            System.out.println("Chat log saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
