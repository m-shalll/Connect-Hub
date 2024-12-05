 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author AbdElrahman
 */
public class FriendManagement {
// Send a friend request
      public void sendFriendRequest(User s, User r) throws IOException {
        if (s.getBlocked().contains(r.getUserId())) {
            throw new IOException("Blocked user");
            
        }
        if (r.getFriendReq().containsKey(s.getUserId())) {
           throw new IOException("Request already sent");
            
        }
           if (r==s) {
           throw new IOException("same user");
            
        }
        r.getFriendReq().put(s.getUserId(), "pending");
       
    }

    // Accept friend request
    public void acceptFriendRequest(User r, User s) throws IOException {
        //if statement maybe later removed
        
        /*if (!r.getFriendReq().containsKey(s) || 
            !r.getFriendReq().get(s).equals("pending")) {
            throw new IOException("No request from this user");
           
        }*/
        r.getFriends().add(s.getUserId());
        s.getFriends().add(r.getUserId());
        r.getFriendReq().put(s.getUserId(), "accepted");

    }

    // Decline friend request
    public void declineFriendRequest(User r, User s)throws IOException {
        if (!r.getFriendReq().containsKey(s.getUserId())) {
            throw new IOException("No request from this user");
        }
        r.getFriendReq().put(s.getUserId(), "Declined");

    }
    //Friends suggestions
    public ArrayList<String> suggestedFriends(User x,ArrayList<User>users){
   ArrayList<String> suggested = new ArrayList<>();
   for(User i:users){
       if(!x.getFriends().contains(i.getUserId())&&x.getBlocked().contains(i.getUserId())&&!x.getUserId().equals(i.getUserId()))
   suggested.add(i.getUserId());
   }
    
    
    return suggested;
    }
    //Remove a friend
    public void removeFriend(User u,User rem)throws IOException{
    if(u.getFriends().contains(rem.getUserId())){
        
        u.getFriends().remove(rem.getUserId());
        rem.getFriends().remove(u.getUserId());
            }
    else
       throw new IOException("User is not a friend") ;
    }
//Block user
public void blockUser(User u,User b)throws IOException{
if (u.getBlocked().contains(b.getUserId())) {
            throw new IOException("User already blocked");
        }
if(u.getFriends().contains(b.getUserId())){
u.getFriends().remove(b.getUserId());
b.getFriends().remove(u.getUserId());
}
u.getBlocked().add(b.getUserId());



}
    }

