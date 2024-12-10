
package Backend;

import java.util.ArrayList;

public interface GroupInterface {

    public void setGroupPhoto(String groupPhoto);
    public void setAdmin(String admin);
    public void setNormalUsers(ArrayList<String> normalUsers);
    public void setCoAdmin(ArrayList<String> coAdmin);
    public void setName(String name);
    public void setDescription(String description);
    public void setGroupPosts(ArrayList<ContentCreation> groupPosts);

    public String getName();
    public ArrayList<String> getCoAdmin();
    public ArrayList<String> getNormalUsers();
    public ArrayList<String> getAdmin();
    public String getGroupPhoto();
    public ArrayList<ContentCreation> getGroupPosts();
}
    
}
