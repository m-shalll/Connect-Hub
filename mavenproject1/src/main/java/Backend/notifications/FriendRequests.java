/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.notifications;

/**
 *
 * @author Dell
 */
public class FriendRequests extends Notification {
    public String secondUser;
    public FriendRequests(){
        super();
        
    }
    @Override
    public void setMessage() {
        this.message="You have a new friend request from "+secondUser;
    }
    public String getMessage(){
        return this.message;
    }

    public String getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(String secondUser) {
        this.secondUser = secondUser;
    }
}
