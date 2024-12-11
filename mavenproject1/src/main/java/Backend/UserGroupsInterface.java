
package Backend;
import java.util.ArrayList;

public interface UserGroupsInterface {
    public ArrayList<String> returnAllGroupNames();
    public ArrayList<String> returnGroupNamesByUserId(String userId);
    public ArrayList<GroupInterface> returnGroupsByUserId(String userId);
    public GroupInterface returnGroup(String groupName);
    public boolean isUserinGroup(String userId, String groupName);
    public void addUserToGroup(String userId, String groupName);
    public void removeUserfromGroup(String userId, String groupName);
}
