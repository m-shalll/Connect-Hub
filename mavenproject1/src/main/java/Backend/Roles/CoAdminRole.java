package Backend.Roles;

import Backend.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CoAdminRole extends RoleDecorator {

    private UserGroupsInterface userGroups;
    private final AccountManagement accManager = AccountManagement.getInstance();
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
    public void execute(String action, String data, Object data1, Object data2) {

    }

    @Override
    public void execute(String action, Object data, Object data2) {
        if (canPerform(action)) {
            switch (action) {
                case "editPost" ->
                    editPost((GroupInterface) data, (ContentCreation) data2);
                case "deletePost" ->
                    deletePost((GroupInterface) data, (ContentCreation) data2);
                case "removeUser" ->
                    removeUser((String) data, (GroupInterface) data2);
                case "approveUser" ->
                    approveUser((String) data, (GroupInterface) data2);
                case "declineUser" ->
                    declineUser((String) data, (String) data2);
            }
        } else {
            throw new UnsupportedOperationException(action + " is not permitted");
        }
    }

    private void deletePost(GroupInterface group, ContentCreation post) {
        ArrayList<ContentCreation> groupPosts = group.getGroupPosts();
        for (int i = 0; i < groupPosts.size(); i++) {
            if (groupPosts.get(i).equals(post)) {
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
        User currentUser;
        try {
            currentUser = accManager.getUser(userId);
            Map<String, String> roles = currentUser.getRoles();
            roles.remove(group.getName());
            currentUser.setRoles(roles);
            ArrayList<User> users = accManager.loadUsers();
            for (User user : users) {
                if (user.getUserId().equals(currentUser.getUserId())) {
                    user = currentUser;
                }
            }
            AccountManagement.saveUsers(users);
        } catch (IOException ex) {
            Logger.getLogger(CoAdminRole.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void approveUser(String userId, GroupInterface currentGroup) {
        if (currentGroup.getGroupRequests().containsKey(userId) && currentGroup.getGroupRequests().get(userId).equals("pending")) {
            currentGroup.getGroupRequests().put(userId, "approved");
            userGroups.addUserToGroup(userId, currentGroup);
            try {
                User currentUser = accManager.getUser(userId);
                GroupInterface group = userGroups.returnGroup(currentGroup.getName());
                Map<String, String> roles = currentUser.getRoles();
                if (roles.get(currentGroup.getName()).equals("NormalUserRole")) {
                    Role normal = new NormalUserRole(accManager.getUserRole(roles, group.getName()), userGroups);
                    roles.put(currentGroup.getName(), "NormalUserRole");
                    currentUser.setRoles(roles);
                    ArrayList<User> users = accManager.loadUsers();
                    for (User user : users) {
                        if (user.getUserId().equals(userId)) {
                            user = currentUser;
                        }
                    }
                    AccountManagement.saveUsers(users);

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private void declineUser(String userId, String groupName) {
        GroupInterface currentGroup = userGroups.returnGroup(groupName);
        if (currentGroup.getGroupRequests().containsKey(userId) && currentGroup.getGroupRequests().get(userId).equals("pending")) {
            currentGroup.getGroupRequests().put(userId, "declined");
        }
    }

}
