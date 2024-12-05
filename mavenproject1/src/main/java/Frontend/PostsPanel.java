
package Frontend;
import javax.swing.*;
import java.awt.*;
import Backend.*;

public class PostsPanel {
    public static JPanel createPost(Post p){
        JPanel postPanel = new JPanel();
        postPanel.setLayout(new BorderLayout());
        postPanel.setBorder(BorderFactory.createEmptyBorder());
        
        JLabel usernameLabel = new JLabel(p.getContentPublisher());
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        postPanel.add(usernameLabel, BorderLayout.NORTH);
        
        ImageIcon imageIcon = new ImageIcon(p.getContent().getImageFilePath());
        JLabel imageLabel = new JLabel(imageIcon);
        postPanel.add(imageLabel, BorderLayout.CENTER);
        
        JLabel captionLabel = new JLabel(p.getContent().getCaption());
        captionLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        postPanel.add(captionLabel, BorderLayout.SOUTH);
        
        return postPanel;
    }
}
