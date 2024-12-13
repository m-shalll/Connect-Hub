/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.notifications;

/**
 *
 * @author Dell
 */
public class NewPosts extends Notification {
    String groupName;
    String contentId;
    public NewPosts(){
        super();
        
    }
    @Override
    public void setMessage() {
        this.message="A new post has been added to "+groupName;
    }
    public String getMessage(){
        return this.message;
    }
}
