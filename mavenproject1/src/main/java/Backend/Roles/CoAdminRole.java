package Backend.Roles;

import Backend.ContentCreation;
import Backend.GroupInterface;
import Backend.User;
import Backend.UserGroups;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class CoAdminRole extends RoleDecorator {
    UserGroups userGroups;
    private final Set<String> allowedActions = Set.of(
            "removeUser", "editPost", "deletePost", "approveUser", "declineUser"
    );

    public CoAdminRole(Role wrappedRole) {
        super(wrappedRole);
    }

    @Override
    public boolean canPerform(String action) {
        return allowedActions.contains(action) || super.canPerform(action);
    }

    @Override
    public void execute(String action, String data) {
    }

    @Override
    public void execute(String action, String data, Object data2) {
        if (canPerform(action)) {
            switch (action) {
                case "removeUser" -> removeUser(data, (String) data2);
                case "editPost" -> editPost(data, (ContentCreation) data2);
                case "deletePost" -> deletePost(data, (String) data2);
                case "approveUser" -> approveUser(data, (String) data2);
                case "declineUser" -> declineUser(data, (String) data2);
            }

        } else {
            super.execute(action, data);
        }
    }


    private void deletePost(String postId, String groupName) {
    }

    private void editPost(String postId, ContentCreation groupName) {
    }

    private void removeUser(String userId, String groupName) {
        userGroups.removeUserfromGroup(userId, groupName);
    }

    private void approveUser(String userId, String groupName) {
        GroupInterface currentGroup = userGroups.returnGroup(groupName);
        if(currentGroup.getGroupRequests().containsKey(userId) && currentGroup.getGroupRequests().get(userId).equals("pending")) {
            currentGroup.getGroupRequests().put(userId, "approved");
            userGroups.addUserToGroup(userId, groupName);
        }
    }

    private void declineUser(String userId, String groupName) {
        GroupInterface currentGroup = userGroups.returnGroup(groupName);
        if(currentGroup.getGroupRequests().containsKey(userId) && currentGroup.getGroupRequests().get(userId).equals("pending")) {
            currentGroup.getGroupRequests().put(userId, "declined");
        }
    }


}
