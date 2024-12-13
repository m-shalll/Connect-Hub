/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.notifications;

/**
 *
 * @author Dell
 */
public class NewStatus extends Notification {
    String groupName;
    public NewStatus(){
        super();
        
    }
    @Override
    public void setMessage() {
        this.message="A new status has been set in group: "+groupName;
    }
    public String getMessage(){
        return this.message;
    }
}
