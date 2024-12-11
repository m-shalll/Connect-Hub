package Backend.Roles;

import Backend.*;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class AdminRole extends RoleDecorator {
    UserGroups userGroups;
    private final GroupManagement groupManagement = GroupManagement.getInstance();
    private final AccountManagement accManager = AccountManagement.getInstance();
    private final Set<String> allowedActions = Set.of(
        "promoteUser", "demoteUser", "deleteGroup"
);
    public AdminRole(Role wrappedRole) {
        super(wrappedRole);
    }

    @Override
    public boolean canPerform(String action) {
        return allowedActions.contains(action) || super.canPerform(action);
    }

    @Override
    public void execute(String action, String data, Object data2) {
        if (canPerform(action)) {
            switch (action) {
                case "promoteUser" -> promoteUser(data, (String)data2);
                case "demoteUser" -> demoteUser(data, (String)data2);
                case "deleteGroup" -> deleteGroup(data);
            }

        } else {
            super.execute(action, data);
        }

    }
    public void execute(String action, String data) {
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
                Role promotion = new CoAdminRole(roles.get(groupName));
                roles.put(groupName, promotion);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
