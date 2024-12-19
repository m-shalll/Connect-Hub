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
    public String groupName;
    public NewUser(){
        super();
    }
    @Override
    public void setMessage() {
        this.message=this.getUserId()+" has been added to "+groupName;
    }
    public String getMessage(){
        return this.message;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
