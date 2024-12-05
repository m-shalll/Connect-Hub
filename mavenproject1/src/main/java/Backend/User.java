package Backend;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.ArrayList;
import java.util.*;

public class User {
    private final String userId;
    private String Email;
    private String userName;
    private String password;
    private String dateOfBirth;
    private String status;
    private String salt;
    private String hashedPassword;
    private ArrayList<String> friends=new ArrayList<>();
    private ArrayList<String> blocked=new ArrayList<>();
    private Map<String, String> friendReq=new HashMap<>(); 
    

    public ArrayList<String> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
    }

    public ArrayList<String> getBlocked() {
        return blocked;
    }

    public void setBlocked(ArrayList<String> blocked) {
        this.blocked = blocked;
    }

    public Map<String, String> getFriendReq() {
        return friendReq;
    }

    public void setFriendReq(Map<String, String> friendReq) {
        this.friendReq = friendReq;
    }

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
}
