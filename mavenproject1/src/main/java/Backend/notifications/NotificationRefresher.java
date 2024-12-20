/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.notifications;

import java.util.ArrayList;

public class NotificationRefresher implements Runnable {
    ArrayList<Notification> notifications;
    @Override
    public void run() {
            try {
                NotificationManager noti=new NotificationManager();
                this.notifications=noti.load();
                Thread.sleep(1000);
                noti.save(this.notifications);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Notification refresher interrupted.");
            } catch (Exception e) {
                System.err.println("Error refreshing notifications: " + e.getMessage());
            }
        }
    public ArrayList<Notification> getNotifications(){
        return this.notifications;
    }
}
