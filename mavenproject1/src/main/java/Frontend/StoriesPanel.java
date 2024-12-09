
package Frontend;
import javax.swing.*;
import java.awt.*;
import Backend.*;
import java.io.IOException;
import java.util.ArrayList;

public class StoriesPanel extends JPanel{
    public StoriesPanel(User currentUser){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBounds(0,0,387,287);
        
        Story currentStory = UserStories.returnStory(currentUser);
        JLabel emptyString = new JLabel("");
        add(emptyString, BorderLayout.NORTH);
        
        ImageIcon originalIcon = new ImageIcon(currentStory.getContent().getImageFilePath());
        Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(resizedIcon);
        add(imageLabel, BorderLayout.CENTER);
        
        JLabel captionLabel = new JLabel(currentStory.getContent().getCaption());
        captionLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        add(captionLabel, BorderLayout.SOUTH);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
    
}
