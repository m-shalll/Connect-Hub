package Backend;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

public class User {
    @JsonProperty
    private final String userId;
    @JsonProperty("email")
    private String Email;
    @JsonProperty("username")
    private String userName;
    @JsonProperty
    private String password;
    @JsonProperty("Date-of-birth")
    private String dateOfBirth;
    @JsonProperty
    private String status;
    @JsonProperty
    private String salt;
    //private String hashedPassword; unnecessary
    private PasswordManager passwordManager  = new PasswordManager();

    public User(String password, String email, String dateOfBirth, String userName, String userId) {
        //this.password = password; unnecessary
        this.Email = email;
        this.status = "online";
        this.dateOfBirth = dateOfBirth;
        this.userName = userName;
        this.userId = userId;
        this.salt = passwordManager.generateSalt(16);
        this.password = passwordManager.updatePassword(password, this.salt);
    }

    public String getUserId() {
        return userId;
    }
    public String  getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getSalt() { return salt; }
    public void setSalt() { this.salt = passwordManager.generateSalt(16); }
    public void setStatusOn(){
        this.status="online";
    }
    public void setStatusOff(){
        this.status="offline";
    }
}
