package Backend;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
public class User {
    private final String userId;
    private String Email;
    private String userName;
    private String password;
    private String dateOfBirth;
    private String status;
    private String salt;
    private String hashedPassword;

    public User(String password, String email, String dateOfBirth, String userName, String userId) {
        this.password = password;
        this.Email = email;
        this.status = "online";
        this.dateOfBirth = dateOfBirth;
        this.userName = userName;
        this.userId = userId;
        this.salt=generateSalt(16);
        this.hashedPassword=hashPassword(password, this.salt);;
    }
    private String generateSalt(int length) {
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
    public String getUserId() {
        return userId;
    }
    public void setStatusOn(){
        this.status="online";
    }
    public void setStatusOff(){
        this.status="offline";
    }

    public String getEmail() {
        return Email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getStatus() {
        return status;
    }

    public String getSalt() {
        return salt;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
