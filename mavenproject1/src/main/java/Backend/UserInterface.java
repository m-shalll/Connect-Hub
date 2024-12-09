/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Backend;
import java.util.ArrayList;
import java.util.Map;
/**
 *
 * @author AbdElrahman
 */
public interface UserInterface{
        // User Identification and Account Details
    String getUserId();
    void setUserId(String userId);

    String getEmail();
    void setEmail(String email);

    String getUserName();
    void setUserName(String userName);

    String getPassword();
    void setPassword(String password);

    String getSalt();
    void setSalt(String salt);
    void buildersetSalt();
    void buildersetPassword(String password);

    // User Profile Details
    String getDateOfBirth();
    void setDateOfBirth(String dateOfBirth);

    String getStatus();
    void setStatusOn();
    void setStatusOff();

    String getUserPhoto();
    void setUserPhoto(String userPhoto);

    String getUserCover();
    void setUserCover(String userCover);

    String getUserBio();
    void setUserBio(String userBio);

    // Social Information
    ArrayList<String> getFriends();
    void setFriends(ArrayList<String> friends);

    ArrayList<String> getBlocked();
    void setBlocked(ArrayList<String> blocked);

    Map<String, String> getFriendReq();
    void setFriendReq(Map<String, String> friendReq);
    
}
