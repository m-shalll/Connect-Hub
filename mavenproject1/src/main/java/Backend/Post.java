
package Backend;
import java.time.LocalDateTime;

public class Post extends ContentCreation{
    public Post(String contentID, User contentPublisher, Content content, LocalDateTime timeStamp){
        super(contentID, contentPublisher, content, timeStamp);
    }
}
