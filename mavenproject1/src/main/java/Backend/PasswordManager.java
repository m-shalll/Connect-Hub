package Backend;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class PasswordManager {

    private static PasswordManager instance = null;
    private PasswordManager(){

    }
    public static PasswordManager getInstance(){
        if(instance == null){
            instance  = new PasswordManager();
        }
        return instance;
    }

    public String generateSalt(int length) {
            byte[] saltBytes = new byte[length];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(saltBytes);
            return Base64.getEncoder().encodeToString(saltBytes);  // Encode as Base64 to store as string
    }

    // Hash the password with the salt
    private String hashPassword(String password, String salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");  // Use SHA-256 for hashing
            digest.update(salt.getBytes());  // Add the salt to the hash
            byte[] hashedBytes = digest.digest(password.getBytes());  // Hash the password with the salt
            return Base64.getEncoder().encodeToString(hashedBytes);  // Convert the hash to Base64 string
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing the password", e);
        }
    }

    public Boolean verifyPassword(String password, String hashedPassword, String salt) {
        return hashedPassword.equals(hashPassword(password, salt));
    }

    public String returnHashed(String password, String salt) {
        return hashPassword(password, salt);
    }


}