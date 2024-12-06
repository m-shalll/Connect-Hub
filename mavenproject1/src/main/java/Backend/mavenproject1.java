
package Backend;
import Frontend.*;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class mavenproject1 {
    public static void main(String[] args) throws IOException {
        StoryDatabase database = StoryDatabase.getInstance();
        
        Story s1 = (Story)ContentFactory.createContent("story");
        
        Content content = new Content("New story");
        
        s1.setContent(content);
        s1.setContentPublisher("hamza");
        
        ArrayList<Story> stories = new ArrayList<>();
        stories.add(s1);
        
        database.savePosts(stories);
        
        FeedWindow w = new FeedWindow("hamza");
        w.setVisible(true);
//        AccountManagement manager=new AccountManagement();
//        manager.signUp("12345","teg","etgeg","etge","hamza");
//        manager.logIn("hamza");
        
    }
}
