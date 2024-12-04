/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author AbdElrahman
 */
public class FriendManagement {
// Send a friend request
      public void sendFriendRequest(User s, User r) throws IOException {
        if (s.getBlocked().contains(r)) {
            throw new IOException("Blocked user");
            
        }
        if (r.getFriendReq().containsKey(s)) {
           throw new IOException("Request already sent");
            
        }
        r.getFriendReq().put(s, "pending");
       
    }

    // Accept friend request
    public void acceptFriendRequest(User r, User s) throws IOException {
        //if statement maybe later removed
        if (!r.getFriendReq().containsKey(s) || 
            !r.getFriendReq().get(s).equals("pending")) {
            throw new IOException("No request from this user");
           
        }
        r.getFriends().add(s);
        s.getFriends().add(r);
        r.getFriendReq().put(s, "accepted");

    }

    // Decline friend request
    public void declineFriendRequest(User r, User s)throws IOException {
        if (!r.getFriendReq().containsKey(s)) {
            throw new IOException("No request from this user");
        }
        r.getFriendReq().put(s, "Declined");

    }
    //Friends suggestions
   /* public ArrayList<User> suggestedFriends(User x){
   ArrayList<User> y = new ArrayList<>(x.getFriends());
   for(User i:y){ 
   
   }
    
    
    
    }*/
    //Remove a friend
    public void removeFriend(User u,User rem)throws IOException{
    if(u.getFriends().contains(rem)){
        
        u.getFriends().remove(rem);
        rem.getFriends().remove(u);
            }
    else
       throw new IOException("User is not a friend") ;
    }
//Block user
public void blockUser(User u,User b)throws IOException{
if (u.getBlocked().contains(b)) {
            throw new IOException("User already blocked");
        }
if(u.getFriends().contains(b)){
u.getFriends().remove(b);
b.getFriends().remove(u);
}
u.getBlocked().add(b);



}
    }

