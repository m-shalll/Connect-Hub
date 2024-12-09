
package Frontend;
import javax.swing.*;
import java.awt.*;
import Backend.*;
import java.io.IOException;
import java.util.ArrayList;


public class PostsPanel extends JPanel {
    public PostsPanel(Post p) {
        AccountManagement am = new AccountManagement();
        ArrayList<User> users = null;
        try {
            users = am.loadUsers();
        } catch (IOException ex) {
            ex.printStackTrace(); 
        }

        User currentUser = null;
        for (int i = 0; i < users.size(); i++) {
            if (p.getContentPublisher().equals(users.get(i).getUserId())) {
                currentUser = users.get(i);
                break; 
            }
        }
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box topBox = Box.createHorizontalBox();
        ImageIcon icon = new ImageIcon(currentUser.getUserPhoto());
        Image image = icon.getImage();
        Image scaledImage1 = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon circularIcon = new ImageIcon(UserIcon.makeImageCircular(scaledImage1));
        JLabel imageLabel1 = new JLabel(circularIcon);
        JLabel usernameLabel = new JLabel(currentUser.getUserName());
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        topBox.add(imageLabel1);
        topBox.add(Box.createHorizontalStrut(10)); 
        topBox.add(usernameLabel);
        topBox.setAlignmentX(LEFT_ALIGNMENT); 
        add(topBox);
        add(Box.createVerticalStrut(5));
        
        ImageIcon originalIcon = new ImageIcon(p.getContent().getImageFilePath());
        Image scaledImage = originalIcon.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        JLabel imageLabel2 = new JLabel(resizedIcon);
        Box centerBox = Box.createHorizontalBox();
        centerBox.add(Box.createHorizontalStrut(35));
        centerBox.add(imageLabel2);
        centerBox.setAlignmentX(LEFT_ALIGNMENT); 
        add(centerBox);

        JLabel captionLabel = new JLabel(p.getContent().getCaption());
        captionLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        Box bottomBox = Box.createHorizontalBox();
        bottomBox.add(Box.createHorizontalStrut(35));
        bottomBox.add(captionLabel);
        bottomBox.setAlignmentX(LEFT_ALIGNMENT); 
        add(bottomBox);
        add(Box.createVerticalStrut(15));
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

