
package Backend.notifications;

import Backend.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private String fileName="notification.json";
    public void save(ArrayList<Notification> notifications) throws IOException{
        File file = new File(fileName);
        double counter=0;
        for(Notification notification:notifications){
            notification.setNotificationId(counter);
            notification.setMessage();
            counter++;
            if (notification instanceof FriendRequests) {
            notification.setType("Friend");
        } else if (notification instanceof NewUser) {
            notification.setType("User");
        } else if (notification instanceof NewPosts) {
            notification.setType("Post");
        } else if (notification instanceof NewStatus) {
            notification.setType("Status");
        }
        }
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, notifications);
    }
    public ArrayList<Notification> load() throws IOException{
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        return objectMapper.readValue(file,objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Notification.class));

    }
    public void delete(double deleted) throws IOException{
        ArrayList<Notification> list=load();
        for(Notification notification:list){
            if(notification.getNotificationId()==deleted){
                list.remove(notification);
                save(list);
            }
        }
    }
}
