
package Backend;
import java.time.Duration;
import java.time.LocalDateTime;

public class Story extends ContentCreation{
    public Story(String contentID, User contentPublisher, Content content, LocalDateTime timeStamp){
        super(contentID, contentPublisher, content, timeStamp);
    }
    
    public boolean isPast24Hours(){
        Duration duration = Duration.between(timeStamp, LocalDateTime.now());
        return duration.toHours() >= 24;
    }
}
