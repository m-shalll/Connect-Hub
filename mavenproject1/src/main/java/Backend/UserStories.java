
package Backend;
import java.util.ArrayList;

public class UserStories {
    public static Story returnStory(User currentUser){
        ArrayList<ContentCreation> stories = StoryDatabase.getInstance().loadStories();
        for(int i=0; i<stories.size();i++){
            if(stories.get(i).getContentPublisher().equals(currentUser.getUserId())){
                return (Story)stories.get(i);
            }
        }
        return null;
    }
}
