/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Dell
 */
public class UserBuilder {
    private User user;
    public UserBuilder(){
        this.user=new User();
    }
    public UserBuilder setId(String id){
        user.setUserId(id);
        return this;
    }
    public UserBuilder setEmail(String id){
        user.setEmail(id);
        return this;
    }
    public UserBuilder setName(String id){
        user.setUserName(id);
        return this;
    }
    public UserBuilder setPasswordManager(PasswordManager passwordManager){
        user.setPasswordManager(passwordManager);
        return this;
    }
    public UserBuilder setPassword(String id){
        user.setPassword(id);
        return this;
    }
    public UserBuilder setDateOfBirth(String id){
        user.setDateOfBirth(id);
        return this;
    }
    public UserBuilder setStatus(){
        user.setStatusOn();
        return this;
    }
    public UserBuilder setSalt(){
        user.setSalt();
        return this;
    }

    public UserBuilder setUserPhoto(String id){
        user.setUserPhoto(id);
        return this;
    }

    public UserBuilder setUserCover(String id){
        user.setUserCover(id);
        return this;
    }

    public UserBuilder setUserBio(String id){
        user.setUserBio(id);
        return this;
    }
    public void setFriends(ArrayList<String> friends) {
        user.setFriends(friends);
    }



    public void setBlocked(ArrayList<String> blocked) {
        user.setBlocked(blocked);
    }



    public void setFriendReq(Map<String, String> friendReq) {
        user.setFriendReq(friendReq);
    }





    public User build(){
        return this.user;
    }
}
