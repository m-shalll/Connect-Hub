/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.notifications;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class tester {
    public static void main(String[] args) throws IOException{
        NotificationManager noti=new NotificationManager();
        NewUser not=new NewUser();
        not.setGroupName("gym bros");
        not.setUserId("user001");
        NewPosts not1=new NewPosts();
        not1.setGroupName("gym bros");
        not1.setUserId("user001");
        not1.setContentId("1");
        ArrayList<Notification> notifications=new ArrayList<>();
        notifications.add(not);
        notifications.add(not1);
        noti.save(notifications);
        notifications=noti.load();
        if(notifications.get(1) instanceof NewPosts){
            System.out.print("True");
        }
        else{
            System.out.print("False");
        }
        NewPosts newPost = (NewPosts) notifications.get(1);
        System.out.print(newPost.getContentId());
    }
}
