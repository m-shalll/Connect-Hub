
package Backend;
import Frontend.*;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class mavenproject1 {
    public static void main(String[] args) throws IOException {
//        PostDatabase d = PostDatabase.getInstance();
//
//        Post one = (Post)ContentFactory.createContent("post");
//        String filePath = "C:\\Users\\Mostafa Mohamed\\Connect-Hub\\mavenproject1\\Images\\4.jpg";
//        Content user1 = new Content(filePath, "What a great day");
//        one.setContent(user1);
//        one.setContentPublisher("Ameer eid");
//        one.setContentID("1");
//
//        Post two = (Post)ContentFactory.createContent("post");
//        String filePath2 = "C:\\Users\\Mostafa Mohamed\\Connect-Hub\\mavenproject1\\Images\\3.jpg";
//        Content user2 = new Content(filePath2, "Hi my name is waleed");
//        two.setContent(user2);
//        two.setContentPublisher("Waleed");
//        two.setContentID("2");
//
//        ArrayList<Post> p = new ArrayList<>();
//        p.add(one);
//        p.add(two);
//
//        d.savePosts(p);
//
//        FeedWindow w = new FeedWindow();
//        w.setVisible(true);
//    

        
            AccountManagement manager=new AccountManagement();

            FriendManagement friendManager = new FriendManagement();
          
            ArrayList<User> users = manager.loadUsers();
     

friendManager.sendFriendRequest(users.get(1), users.get(12));
friendManager.acceptFriendRequest(users.get(12), users.get(1));




            AccountManagement.saveUsers(users);
        
        
        
    }
}
