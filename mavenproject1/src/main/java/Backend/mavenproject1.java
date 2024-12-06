
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
          
            ArrayList<User> users = AccountManagement.loadUsers();
            friendManager.sendFriendRequest(users.get(0), users.get(1));
friendManager.acceptFriendRequest(users.get(1), users.get(0));
friendManager.sendFriendRequest(users.get(2), users.get(3));
friendManager.declineFriendRequest(users.get(3), users.get(2));
friendManager.blockUser(users.get(3), users.get(2));
friendManager.sendFriendRequest(users.get(4), users.get(5));
friendManager.acceptFriendRequest(users.get(5), users.get(4));
friendManager.sendFriendRequest(users.get(6), users.get(7));
friendManager.declineFriendRequest(users.get(7), users.get(6));
friendManager.blockUser(users.get(7), users.get(6));
friendManager.sendFriendRequest(users.get(8), users.get(9));
friendManager.acceptFriendRequest(users.get(9), users.get(8));
friendManager.sendFriendRequest(users.get(10), users.get(11));
friendManager.declineFriendRequest(users.get(11), users.get(10));
friendManager.blockUser(users.get(11), users.get(10));
friendManager.sendFriendRequest(users.get(12), users.get(13));
friendManager.acceptFriendRequest(users.get(13), users.get(12));
friendManager.sendFriendRequest(users.get(14), users.get(15));
friendManager.declineFriendRequest(users.get(15), users.get(14));
friendManager.blockUser(users.get(15), users.get(14));
friendManager.sendFriendRequest(users.get(16), users.get(17));
friendManager.acceptFriendRequest(users.get(17), users.get(16));
friendManager.sendFriendRequest(users.get(18), users.get(19));
friendManager.declineFriendRequest(users.get(19), users.get(18));
friendManager.blockUser(users.get(19), users.get(18));



            AccountManagement.saveUsers(users);
        
        
    }
}
