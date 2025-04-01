import java.io.*;

public class FileBackupSystem {
    public static void main(String[] args) {
        String source = "original.txt";
        String backup = "backup.dat";

        // Backup
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(backup)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            System.out.println("Backup created.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Recovery
        try (FileInputStream fis = new FileInputStream(backup);
             FileOutputStream fos = new FileOutputStream("recovered.txt")) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            System.out.println("File recovered.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
