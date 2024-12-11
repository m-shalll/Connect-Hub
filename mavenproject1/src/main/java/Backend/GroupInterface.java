
package Backend;

import java.util.ArrayList;
import java.util.Map;

public interface GroupInterface {

    public void setGroupPhoto(String groupPhoto);
    public void setAdmin(String admin);
    public void setUsers(ArrayList<String> normalUsers);
    public void setCoAdmin(ArrayList<String> coAdmin);
    public void setName(String name);
    public void setDescription(String description);
    public void setGroupPosts(ArrayList<ContentCreation> groupPosts);
    public void setGroupRequests(Map<String, String> friendReq);

    public String getName();
    public String getDescription();
    public ArrayList<String> getCoAdmin();
    public ArrayList<String> getUsers();
    public ArrayList<String> getAdmin();
    public String getGroupPhoto();
    public ArrayList<ContentCreation> getGroupPosts();
    public Map<String, String> getGroupRequests();
}
    

