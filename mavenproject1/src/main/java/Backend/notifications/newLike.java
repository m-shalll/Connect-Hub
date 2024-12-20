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
public class newLike extends Notification {
    public String username;
    public String postId;
    public newLike(){
        super();

    }
    @Override
    public void setMessage() {
        this.message= username+"liked your post";
    }
    public String getMessage(){
        return this.message;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }
    public void setPostId(String postId) {
        this.postId = postId;
    }
    public String getPostId() {
        return this.postId;
    }

}
