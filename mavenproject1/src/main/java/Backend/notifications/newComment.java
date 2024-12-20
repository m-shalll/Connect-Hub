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
public class NewComment extends Notification {
    public String comment;
    public String commentId;
    public String commentAuthor;
    public String postId;
    public NewComment(){
        super();

    }
    @Override
    public void setMessage() {
        this.message= commentAuthor + "added a comment to your post: " + comment;
    }
    public String getMessage(){
        return this.message;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
    public String getCommentAuthor() { return this.commentAuthor; }
    public void setCommentAuthor(String commentAuthor) { this.commentAuthor = commentAuthor; }
    public String getPostId() { return this.postId; }
    public void setPostId(String postId) { this.postId = postId; }
}
