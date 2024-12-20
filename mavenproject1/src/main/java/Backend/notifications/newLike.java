/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.notifications;

import Backend.PostInteraction.Comment;

/**
 *
 * @author Dell
 */
public class NewLike extends Notification {
    public String secondUser;
    public String postId;
    public NewLike(){
        super();

    }
    @Override
    public void setMessage() {
        this.message= secondUser+"liked your post";
    }
    public String getMessage(){
        return this.message;
    }
    public void setSecondUser(String username) {
        this.secondUser = username;
    }
    public String getSecondUser() {
        return this.secondUser;
    }
    public void setPostId(String postId) {
        this.postId = postId;
    }
    public String getPostId() {
        return this.postId;
    }

}
