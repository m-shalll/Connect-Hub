
package Frontend;
import Backend.*;
import javax.swing.*;
import java.awt.*;

public class PostsPanel {
    public static JPanel createPostPanel(Post p) {
        JPanel postPanel = new JPanel();
        postPanel.setLayout(new BorderLayout());
        postPanel.setBorder(BorderFactory.createEmptyBorder());

        JLabel userName = new JLabel(p.getContentPublisher());
        userName.setFont(new Font("Arial", Font.BOLD, 12));
        postPanel.add(userName, BorderLayout.NORTH);

        ImageIcon imageIcon = new ImageIcon(p.getContent().getImageFilePath());
        JLabel imageLabel = new JLabel(imageIcon);
        postPanel.add(imageLabel, BorderLayout.CENTER);

        JLabel caption = new JLabel(p.getContent().getCaption());
        caption.setFont(new Font("Arial", Font.ITALIC, 14));
        postPanel.add(caption, BorderLayout.SOUTH);

        return postPanel;
    }
}
