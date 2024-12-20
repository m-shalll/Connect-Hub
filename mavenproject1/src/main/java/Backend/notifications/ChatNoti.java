/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.notifications;

/**
 *
 * @author Dell
 */
public class ChatNoti extends Notification{
    public String secondUser;
    public String getMessage(){
        return this.message;
    }
    @Override
    public void setMessage() {
        this.message="You got a new text from "+this.secondUser;
    }
    public String getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(String secondUser) {
        this.secondUser = secondUser;
    }
}
