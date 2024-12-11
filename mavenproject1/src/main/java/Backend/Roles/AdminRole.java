package Backend.Roles;

import Backend.AccountManagement;

import java.io.IOException;
import java.util.Set;

public class AdminRole extends RoleDecorator {
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
    public void execute(String action, String data) {
        if (canPerform(action)) {
            switch (action) {
                case "promoteUser" -> promoteUser(data);
                case "demoteUser" -> demoteUser(data);
                case "deleteGroup" -> deleteGroup();
            }

        } else {
            throw new UnsupportedOperationException(action + " is not permitted");
        }

    }


    private void deleteGroup() {
    }

    private void demoteUser(String userId) {
    }

    private void promoteUser(String userId) {
    }

}
