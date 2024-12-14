package Backend.notifications;

import java.io.IOException;
import java.util.ArrayList;

public class hfxhx {
    public static void main(String[] args) throws IOException{
        NotificationManager noti = new NotificationManager();
        
        // Creating NewUser notification
        NewUser not = new NewUser();
        not.setUserId("user001");
        not.setSecondUser("user002");
        not.setGroupName("gym bros");
        not.setMessage();
        
        // Creating NewPosts notification
        NewPosts not1 = new NewPosts();
        not1.setUserId("user001");
        not1.setGroupName("gym bros");
        not1.setContentId("1");
        not1.setMessage();
        
        FriendRequests not2 = new FriendRequests();
        not2.setNotificationId(1);
        not2.setUserId("user001");
        not2.setSecondUser("user002");
        not2.setMessage();
        
        // Adding notifications to the list
        ArrayList<Notification> notifications = noti.load();
        notifications.add(not);
        notifications.add(not1);
        notifications.add(not2);
        noti.save(notifications);
        
        // Loading and validating notifications
        notifications = noti.load();
        if (notifications.get(1) instanceof NewPosts) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
