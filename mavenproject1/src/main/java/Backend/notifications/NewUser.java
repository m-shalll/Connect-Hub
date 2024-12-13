/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.notifications;

/**
 *
 * @author Dell
 */
public class NewUser extends Notification {
    String secondUser;
    String groupName;
    public NewUser(){
        super();
        
    }
    @Override
    public void setMessage() {
        this.message=secondUser+" has been added to "+groupName;
    }
    public String getMessage(){
        return this.message;
    }
}
