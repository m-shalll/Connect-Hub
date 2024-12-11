package Backend.Roles;

import java.util.Set;

public class NormalUserRole extends RoleDecorator {
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
    public void execute(String action, String data) {
        if (canPerform(action)) {
            switch (action) {
                case "addPost" -> addPost();
                case "leaveGroup" -> leaveGroup();
            }

        } else {
            throw new UnsupportedOperationException(action + " is not permitted");
        }

    }

    private void leaveGroup() {
    }

    private void addPost() {
    }
}
