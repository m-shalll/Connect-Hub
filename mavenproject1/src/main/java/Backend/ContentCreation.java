
package Backend;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public abstract class ContentCreation {
    @JsonProperty
    protected String contentID;
    @JsonProperty
    private String contentPublisher;
    @JsonProperty
    protected Content content;
    @JsonProperty
    protected LocalDateTime timeStamp;
    
    public ContentCreation(){
        timeStamp = LocalDateTime.now();
    }
    public String getContentID() {
        return contentID;
    }

    public void setContentID(String contentID) {
        this.contentID = contentID;
    }

    public String getContentPublisher() {
        return contentPublisher;
    }

    public void setContentPublisher(String contentPublisher) {
        this.contentPublisher = contentPublisher;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
