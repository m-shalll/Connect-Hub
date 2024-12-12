
package Backend;
import java.util.ArrayList;

public interface UserGroupsInterface {
    public ArrayList<String> returnAllGroupNames();
    public ArrayList<String> returnGroupNamesByUserId(String userId);
    public ArrayList<GroupInterface> returnGroupsByUserId(String userId);
    public GroupInterface returnGroup(String groupName);
    public boolean isUserinGroup(String userId, GroupInterface currentGroup);
    public void addUserToGroup(String userId, GroupInterface currentGroup);
    public void removeUserfromGroup(String userId, GroupInterface currentGroup);
    public void sendGroupRequest(User user, GroupInterface group);
}
