package Backend.PostInteraction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Comment {
    @JsonProperty
    private String commentId;
    @JsonProperty
    private String text;
    @JsonProperty
    private String postId;
    @JsonProperty
    private String username;
    @JsonProperty
    private LocalDateTime timeStamp;

    Comment(String text, String postId, String username, LocalDateTime timeStamp, String commentId) {
        this.text = text;
        this.postId = postId;
        this.username = username;
        this.timeStamp = timeStamp;
        this.commentId = commentId;
    }
    public String getText() {
        return text;
    }

    public String getPostId() {
        return postId;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    public String getCommentId() {
        return commentId;
    }
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
}
