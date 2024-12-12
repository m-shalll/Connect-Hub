
package Backend.Roles;
import Backend.*;
import java.util.ArrayList;
import java.util.Set;

public class CoAdminRole extends RoleDecorator {
    private UserGroupsInterface userGroups;
    private final Set<String> allowedActions = Set.of(
            "removeUser", "editPost", "deletePost", "approveUser", "declineUser"
    );

    public CoAdminRole(Role wrappedRole, UserGroupsInterface userGroups) {
        super(wrappedRole);
        this.userGroups = userGroups;
    }

    @Override
    public boolean canPerform(String action) {
        return allowedActions.contains(action) || super.canPerform(action);
    }

  
    @Override
    public void execute(String action, String data, Object data1, Object data2){
        
    }
    @Override
    public void execute(String action, Object data, Object data2) {
        if (canPerform(action)) {
            switch (action) {
                case "editPost" -> editPost((GroupInterface)data, (ContentCreation)data2);
                case "deletePost" -> deletePost((GroupInterface)data, (ContentCreation)data2);
                case "removeUser" -> removeUser((String)data, (GroupInterface) data2);
                case "approveUser" -> approveUser((String)data, (GroupInterface) data2);
                case "declineUser" -> declineUser((String)data, (String) data2);
            }
        } else {
            throw new UnsupportedOperationException(action + " is not permitted");
        }
    }


    private void deletePost(GroupInterface group, ContentCreation post) {
        ArrayList<ContentCreation> groupPosts = group.getGroupPosts();
        for(int i=0; i<groupPosts.size(); i++){
            if(groupPosts.get(i).equals(post)){
                groupPosts.remove(groupPosts.get(i));
                break;
            }
        }
        group.setGroupPosts(groupPosts);
    }
    private void editPost(GroupInterface group, ContentCreation post) {
        
    }
    private void removeUser(String userId, GroupInterface group) {
        userGroups.removeUserfromGroup(userId, group);
    }

    private void approveUser(String userId, GroupInterface currentGroup) {
        if(currentGroup.getGroupRequests().containsKey(userId) && currentGroup.getGroupRequests().get(userId).equals("pending")) {
            currentGroup.getGroupRequests().put(userId, "approved");
            userGroups.addUserToGroup(userId, currentGroup);
        }
    }

    private void declineUser(String userId, String groupName) {
        GroupInterface currentGroup = userGroups.returnGroup(groupName);
        if(currentGroup.getGroupRequests().containsKey(userId) && currentGroup.getGroupRequests().get(userId).equals("pending")) {
            currentGroup.getGroupRequests().put(userId, "declined");
        }
    }


}
