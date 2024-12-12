package Backend.Roles;

import Backend.*;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class AdminRole extends RoleDecorator {
    private UserGroupsInterface userGroups;
    private final GroupManagement groupManagement = GroupManagement.getInstance();
    private final AccountManagement accManager = AccountManagement.getInstance();
    private final Set<String> allowedActions = Set.of(
        "promoteUser", "demoteUser", "deleteGroup"
);
    public AdminRole(Role wrappedRole, UserGroupsInterface userGroups) {
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
                case "promoteUser" -> promoteUser((String)data, (String)data2);
                case "demoteUser" -> demoteUser((String)data, (String)data2);
                case "deleteGroup" -> deleteGroup((String)data);
            }

        } else {
            throw new UnsupportedOperationException(action + " is not permitted");
        }

    }
    @Override
    public void execute(String action, String data, Object data1, Object data2) {
        
    }
    private void deleteGroup(String groupName) {
        groupManagement.deleteGroup(groupName);
    }

    private void demoteUser(String userId, String groupName) {
        try {
            User user = accManager.getUser(userId);
            GroupInterface group = userGroups.returnGroup(groupName);
            Map<String,Role> roles = user.getRoles();
            if(roles.get(groupName) instanceof CoAdminRole) {}
            roles.put(groupName, (NormalUserRole)roles.get(groupName).unWrap());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void promoteUser(String userId, String groupName) {
        try {
            User user = accManager.getUser(userId);
            GroupInterface group = userGroups.returnGroup(groupName);
            Map<String,Role> roles = user.getRoles();
            if(roles.get(groupName) instanceof NormalUserRole){
                Role promotion = new CoAdminRole(roles.get(groupName), userGroups);
                roles.put(groupName, promotion);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
