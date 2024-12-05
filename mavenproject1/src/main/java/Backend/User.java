package Backend;

import com.fasterxml.jackson.annotation.JsonProperty;


public class User {
    @JsonProperty
    private String userId;
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
    @JsonProperty("Profile photo")
    private String userPhoto;
    @JsonProperty("Cover photo")
    private String userCover;
    @JsonProperty("Bio")
    private String userBio;
    private PasswordManager passwordManager;


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

    public void setEmail(String email) {
        Email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPasswordManager(PasswordManager passwordManager) { this.passwordManager = passwordManager;}

    public void setSalt() {
        this.salt = passwordManager.generateSalt(16);
    }

    public void setPassword(String password) {this.password = passwordManager.returnHashed(password, this.salt);;}

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPhoto(String userPhoto) { this.userPhoto = userPhoto;}

    public void setUserCover(String userCover) { this.userCover = userCover;}

    public void setUserBio(String userBio) { this.userBio = userBio;}



}
