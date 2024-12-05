package Backend;

import com.fasterxml.jackson.annotation.JsonProperty;


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
    @JsonProperty("Profile photo")
    private String userPhoto;
    @JsonProperty("Cover photo")
    private String userCover;
    @JsonProperty("Bio")
    private String userBio;
    private PasswordManager passwordManager;

    public User(String password, String email, String dateOfBirth,
                String userName, String userId) {
        this.Email = email;
        this.status = "online";
        this.dateOfBirth = dateOfBirth;
        this.userName = userName;
        this.userId = userId;
        this.userPhoto = null;
        this.userCover = null;
        this.userBio = null;
        this.passwordManager = new PasswordManager();
        this.salt = passwordManager.generateSalt(16);
        this.password = passwordManager.returnHashed(password, this.salt);
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt() {
        this.salt = passwordManager.generateSalt(16);
    }

    public void setStatusOn() {
        this.status = "online";
    }

    public void setStatusOff() {
        this.status = "offline";
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserCover() {
        return userCover;
    }

    public void setUserCover(String userCover) {
        this.userCover = userCover;
    }

    public String getUserBio() {
        return userBio;
    }

    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }
}
