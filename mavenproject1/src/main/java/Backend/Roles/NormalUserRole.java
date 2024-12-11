package Backend.Roles;

import Backend.UserGroups;

import java.util.Set;

public class NormalUserRole extends RoleDecorator {
    UserGroups userGroups;
    private final Set<String> allowedActions = Set.of(
            "addPost", "leaveGroup"
    );

    public NormalUserRole(Role wrappedRole) {
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
                case "addPost" -> addPost();
                case "leaveGroup" -> leaveGroup(data, (String)data2);
            }

        } else {
            throw new UnsupportedOperationException(action + " is not permitted");
        }
    }

    private void leaveGroup(String userId, String groupName) {
        userGroups.removeUserfromGroup(userId, groupName);
    }

    private void addPost() {
    }
}
