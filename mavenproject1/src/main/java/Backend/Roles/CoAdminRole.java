package Backend.Roles;

import java.util.Set;

public class CoAdminRole extends RoleDecorator {
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
        if (canPerform(action)) {
            switch (action) {
                case "removeUser" -> removeUser(data);
                case "editPost" -> editPost(data);
                case "deletePost" -> deletePost(data);
                case "approveUser" -> approveUser(data);
                case "declineUser" -> declineUser(data);
            }

        } else {
            super.execute(action, data);
        }

    }

    private void deletePost(String postId) {
    }

    private void editPost(String postId) {
    }

    private void removeUser(String userId) {
    }

    private void approveUser(String userId) {
    }

    private void declineUser(String userId) {
    }

}
