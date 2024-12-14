package Backend;
import Backend.notifications.FriendRequests;
import Frontend.*;
import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class mavenproject1 {
    public static void main(String[] args) throws IOException {
//        AccountManagement manager = new AccountManagement();
//        FriendManagement friendManager = new FriendManagement();
//        ArrayList<User> users = manager.loadUsers();
//        // User 0 friendships
//friendManager.sendFriendRequest(users.get(0), users.get(1));
//friendManager.acceptFriendRequest(users.get(1), users.get(0));
//friendManager.sendFriendRequest(users.get(0), users.get(2));
//friendManager.acceptFriendRequest(users.get(2), users.get(0));
//friendManager.sendFriendRequest(users.get(0), users.get(3));
//friendManager.acceptFriendRequest(users.get(3), users.get(0));
//friendManager.sendFriendRequest(users.get(0), users.get(4));
//friendManager.acceptFriendRequest(users.get(4), users.get(0));
//
//// User 1 friendships
//friendManager.sendFriendRequest(users.get(1), users.get(5));
//friendManager.acceptFriendRequest(users.get(5), users.get(1));
//friendManager.sendFriendRequest(users.get(1), users.get(6));
//friendManager.acceptFriendRequest(users.get(6), users.get(1));
//friendManager.sendFriendRequest(users.get(1), users.get(7));
//friendManager.declineFriendRequest(users.get(7), users.get(1));
//friendManager.blockUser(users.get(7), users.get(1));
//friendManager.sendFriendRequest(users.get(1), users.get(8));
//friendManager.acceptFriendRequest(users.get(8), users.get(1));
//
//// User 2 friendships
//friendManager.sendFriendRequest(users.get(2), users.get(9));
//friendManager.acceptFriendRequest(users.get(9), users.get(2));
//friendManager.sendFriendRequest(users.get(2), users.get(10));
//friendManager.acceptFriendRequest(users.get(10), users.get(2));
//friendManager.sendFriendRequest(users.get(2), users.get(11));
//friendManager.declineFriendRequest(users.get(11), users.get(2));
//friendManager.blockUser(users.get(11), users.get(2));
//friendManager.sendFriendRequest(users.get(2), users.get(12));
//friendManager.acceptFriendRequest(users.get(12), users.get(2));
//
//// User 3 friendships
//friendManager.sendFriendRequest(users.get(3), users.get(13));
//friendManager.acceptFriendRequest(users.get(13), users.get(3));
//friendManager.sendFriendRequest(users.get(3), users.get(14));
//friendManager.acceptFriendRequest(users.get(14), users.get(3));
//friendManager.sendFriendRequest(users.get(3), users.get(15));
//friendManager.declineFriendRequest(users.get(15), users.get(3));
//friendManager.blockUser(users.get(15), users.get(3));
//friendManager.sendFriendRequest(users.get(3), users.get(16));
//friendManager.acceptFriendRequest(users.get(16), users.get(3));
//
//// User 4 friendships
//friendManager.sendFriendRequest(users.get(4), users.get(17));
//friendManager.acceptFriendRequest(users.get(17), users.get(4));
//friendManager.sendFriendRequest(users.get(4), users.get(18));
//friendManager.acceptFriendRequest(users.get(18), users.get(4));
//friendManager.sendFriendRequest(users.get(4), users.get(19));
//friendManager.declineFriendRequest(users.get(19), users.get(4));
//friendManager.blockUser(users.get(19), users.get(4));
//friendManager.sendFriendRequest(users.get(4), users.get(5));
//friendManager.acceptFriendRequest(users.get(5), users.get(4));
//
//// Continue similar logic for users 5 to 19
//for (int i = 5; i < 20; i++) {
//    for (int j = 0; j < 4; j++) {
//        int friendIndex = (i + j + 1) % 20; // Ensure we pick other users circularly
//        friendManager.sendFriendRequest(users.get(i), users.get(friendIndex));
//        if ((i + j) % 3 == 0) { // Accept or decline based on a condition
//            friendManager.acceptFriendRequest(users.get(friendIndex), users.get(i));
//        } else {
//            friendManager.declineFriendRequest(users.get(friendIndex), users.get(i));
//            friendManager.blockUser(users.get(friendIndex), users.get(i));
//        }
//    }
//}
//
//AccountManagement.saveUsers(users);

// Repeat similar logic for other users to ensure they each have 4 friends.
        FriendRequests request=new FriendRequests();
        

    }
}