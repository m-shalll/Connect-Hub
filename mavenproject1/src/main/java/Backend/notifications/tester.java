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
    }
}
