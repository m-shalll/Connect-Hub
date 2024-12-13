/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

import Backend.notifications.Notification;
import Backend.notifications.NotificationManager;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
public class Notifications extends JPanel {
    private JFrame frame;
    private JPanel notificationPanel;
    private ArrayList<Notification> notifications;
    public Notifications() throws IOException {
        getNotifications();

        frame = new JFrame("Notifications");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new BorderLayout());

        // Title label
        JLabel titleLabel = new JLabel("Your Notifications", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Notification panel with vertical layout
        notificationPanel = new JPanel();
        notificationPanel.setLayout(new BoxLayout(notificationPanel, BoxLayout.Y_AXIS)); // Stack notifications vertically

        // Scrollable panel
        JScrollPane scrollPane = new JScrollPane(notificationPanel);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Load notifications into the panel
        loadNotifications();

        

        frame.setVisible(true);
    }

    private void loadNotifications() throws IOException {
        for (Notification notification : this.notifications) {
            JTextField notificationField = new JTextField(notification.getMessage());
            notificationField.setEditable(false); 
            notificationField.setMaximumSize(new Dimension(Integer.MAX_VALUE, notificationField.getPreferredSize().height));
            notificationPanel.add(notificationField);
        }

        notificationPanel.revalidate();
        notificationPanel.repaint();
    }
    private void getNotifications() throws IOException{
        NotificationManager manager=new NotificationManager();
        ArrayList<Notification> all=manager.load();
        for(Notification notification:all){
            if(notification.getUserId().equals(ABORT)){
                this.notifications.add(notification);
            }
        }
    }
}
