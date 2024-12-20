package Backend.PostInteraction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Like  {
    @JsonProperty
    private String postId;
    @JsonProperty
    private String username;
    @JsonProperty
    private LocalDateTime timestamp;
    
    
    public Like(){
        
    }
    
    public Like(String postId, String username,LocalDateTime timestamp) {
        this.postId = postId;
        this.username = username;
        this.timestamp = timestamp;
    }

    public String getPostId() {
        return postId;
    }
    public void setPostId(String postId) {
        this.postId = postId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public LocalDateTime getTimeStamp() {
        return timestamp;
    }
    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timestamp = timeStamp;
    }
}
