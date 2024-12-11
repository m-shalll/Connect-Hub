package Backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class User {
    PasswordManager passwordManager = PasswordManager.getInstance();
    @JsonProperty
    private String userId;
    @JsonProperty("email")
    private String Email;
    @JsonProperty("username")
    private String userName;
    @JsonProperty
    private String salt;


    private String hashedPassword;

    @JsonProperty
    private String password;
    @JsonProperty("Date-of-birth")
    private String dateOfBirth;
    @JsonProperty
    private String status;
    @JsonProperty("Profile photo")
    private String userPhoto;
    @JsonProperty("Cover photo")
    private String userCover;
    @JsonProperty("Bio")
    private String userBio;
    private ArrayList<String> friends=new ArrayList<>();
    private ArrayList<String> blocked=new ArrayList<>();
    private Map<String, String> friendReq=new HashMap<>();
    private Map<String, Role> roles = new HashMap<>();

    public Map<String, Role> getRoles() { return roles; }

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

    public String getUserPhoto() { return userPhoto;}

    public String getUserCover() { return userCover;}

    public String getUserBio() { return userBio;}

    public void setRoles(Map<String, Role> roles) { this.roles = roles;}

    public void setEmail(String email) {
        Email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    public void buildersetSalt(){
        this.salt = passwordManager.generateSalt(16);
    }

    public void buildersetPassword(String password){
        this.password = passwordManager.returnHashed(password, salt);
    }
    public void setPassword(String password) 
    {this.password = password;}

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPhoto(String userPhoto) { this.userPhoto = userPhoto;}
    public void buildersetUserPhoto() { this.userPhoto = "Images\\user.jpg";}

    public void setUserCover(String userCover) { this.userCover = userCover;}

    public void setUserBio(String userBio) { this.userBio = userBio;}



}