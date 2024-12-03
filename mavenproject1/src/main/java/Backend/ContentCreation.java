
package Backend;
import java.time.LocalDateTime;

public abstract class ContentCreation {
    protected String contentID;
    private User contentPublisher;
    protected Content content;
    protected LocalDateTime timeStamp;
    
    public String getContentID() {
        return contentID;
    }

    public void setContentID(String contentID) {
        this.contentID = contentID;
    }

    public User getContentPublisher() {
        return contentPublisher;
    }

    public void setContentPublisher(User contentPublisher) {
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
