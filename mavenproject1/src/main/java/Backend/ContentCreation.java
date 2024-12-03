
package Backend;
import java.time.LocalDateTime;

public abstract class ContentCreation {
    protected String contentID;
    private User contentPublisher;
    protected Content content;
    protected LocalDateTime timeStamp;
    
    public ContentCreation(String contentID, User contentPublisher, Content content, LocalDateTime timeStamp) {
        this.contentID = contentID;
        this.contentPublisher = contentPublisher;
        this.content = content;
        this.timeStamp = LocalDateTime.now();
    }
}
