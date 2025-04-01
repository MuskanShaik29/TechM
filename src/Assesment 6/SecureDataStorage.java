import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.Base64;

public class SecureDataStorage {
    public static void main(String[] args) throws Exception {
        String data = "Sensitive User Data";
        SecretKey key = generateKey();
        String encryptedData = encrypt(data, key);
        
        // Store in file
        try (FileWriter writer = new FileWriter("secure_data.txt")) {
            writer.write(encryptedData);
        }
        
        System.out.println("Encrypted Data Saved: " + encryptedData);
    }

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        return keyGen.generateKey();
    }

    public static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }
}
