package Backend;

import java.util.Set;

public class NormalUserRole implements Role {
    private final Set<String> allowedActions = Set.of(
            "addPost", "leaveGroup"
    );

    @Override
    public boolean canPerform(String action) {
        return false;
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
