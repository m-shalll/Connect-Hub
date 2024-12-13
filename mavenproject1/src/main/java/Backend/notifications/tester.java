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
        NewPosts not1=new NewPosts();
        ArrayList<Notification> notifications=noti.load();
        notifications.add(not);
        notifications.add(not1);
        noti.save(notifications);
        notifications=noti.load();
        if(notifications.get(1) instanceof NewPosts){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
        NewPosts newPost = (NewPosts) notifications.get(1);
        System.out.println(newPost.getContentId());
        System.out.println(newPost.getMessage());
    }
}
