package Backend.Roles;

import Backend.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NormalUserRole extends RoleDecorator {
    private UserGroupsInterface userGroups;
    private final AccountManagement accManager = AccountManagement.getInstance();
    private final Set<String> allowedActions = Set.of(
            "addPost", "leaveGroup"
    );

    public NormalUserRole(Role wrappedRole, UserGroupsInterface userGroups) {
        super(wrappedRole);
        this.userGroups = userGroups;
    }

    @Override
    public boolean canPerform(String action) {
        return allowedActions.contains(action) || super.canPerform(action);
    }
    @Override
    public void execute(String action, Object data, Object data2) {
        if (canPerform(action)) {
            switch (action) {
                case "leaveGroup" -> leaveGroup((String)data, (GroupInterface)data2);
            }

        } else {
            throw new UnsupportedOperationException(action + " is not permitted");
        }
    }
    public void execute(String action, String data, Object data1, Object data2){
        if (canPerform(action)) {
            switch (action) {
                case "addPost" -> addPost(data, (GroupInterface)data1, (Content)data2);
            }

        } else {
            throw new UnsupportedOperationException(action + " is not permitted");
        }
    }
    private void leaveGroup(String userId, GroupInterface group) {
        userGroups.removeUserfromGroup(userId, group);
                User currentUser;
        try {
            currentUser = accManager.getUser(userId);
            Map<String, Role> roles = currentUser.getRoles();
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

    private void addPost(String userId, GroupInterface group, Content content) {
        Post p = (Post)ContentFactory.createContent("post");
        p.setContentPublisher(userId);
        p.setContent(content);
        group.getGroupPosts().add(p);
    }
}
