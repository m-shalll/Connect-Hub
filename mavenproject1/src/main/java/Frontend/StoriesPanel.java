
package Frontend;
import javax.swing.*;
import java.awt.*;
import Backend.*;
import java.io.IOException;
import java.util.ArrayList;

public class StoriesPanel extends JPanel{
    public StoriesPanel(String username){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBounds(0,0,387,287);
        
        AccountManagement am = new AccountManagement();
        ArrayList<User> users = null;
        try {
            users = am.loadUsers();
        } catch (IOException ex) {
            
        }
        String currentUser = null;
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getUserName().equals(username)){
                currentUser = users.get(i).getUserId();
            }
        }
        Story currentStory = null;
        ArrayList<Story> stories = StoryDatabase.getInstance().loadStories();
        for(int i=0; i<stories.size();i++){
            if(stories.get(i).getContentPublisher().equals(currentUser)){
                currentStory = stories.get(i);
            }
        }
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
