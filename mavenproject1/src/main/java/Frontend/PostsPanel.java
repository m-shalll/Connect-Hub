
package Frontend;
import javax.swing.*;
import java.awt.*;
import Backend.*;

public class PostsPanel extends JPanel{
    public PostsPanel(Post p){
//        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBounds(250,175,450,780);
        
        JLabel usernameLabel = new JLabel(p.getContentPublisher());
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        add(usernameLabel, BorderLayout.NORTH);
        
        ImageIcon originalIcon = new ImageIcon(p.getContent().getImageFilePath());
        Image scaledImage = originalIcon.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(resizedIcon);
        add(imageLabel, BorderLayout.CENTER);
        
        JLabel captionLabel = new JLabel(p.getContent().getCaption());
        captionLabel.setFont(new Font("Arial", Font.ITALIC, 14));

        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(captionLabel);
        verticalBox.add(Box.createVerticalStrut(15)); 
        add(verticalBox, BorderLayout.SOUTH);
      
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
