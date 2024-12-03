
package Backend;
import java.time.LocalDate;

public class ContentCreation {
    private String contentID;
    private User contentPublisher;
    private Content content;
    private LocalDate timeStamp;
    
    public ContentCreation(String contentID, User contentPublisher, Content content, LocalDate timeStamp) {
        this.contentID = contentID;
        this.contentPublisher = contentPublisher;
        this.content = content;
        this.timeStamp = timeStamp;
    }
}
