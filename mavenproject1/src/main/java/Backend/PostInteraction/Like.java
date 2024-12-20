package Backend.PostInteraction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Like  {
    @JsonProperty
    private String postId;
    @JsonProperty
    private String username;
    @JsonProperty
    private LocalDateTime timeStamp;

    public Like(String postId, String username, LocalDateTime timeStamp) {
        this.postId = postId;
        this.username = username;
        this.timeStamp = timeStamp;
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
}
