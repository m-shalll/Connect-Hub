package Backend;

import java.util.Set;

public class AdminRole implements Role {
private final Set<String> allowedActions = Set.of(
        "promoteUser", "demoteUser", "removeUser", "addPost", "editPost",
        "deletePost", "deleteGroup", "approveUser", "declineUser"
);

    @Override
    public boolean canPerform(String action) {
        return allowedActions.contains(action);
    }

    @Override
    public void execute(String action, String data) {
        if (canPerform(action)) {
            switch (action) {
                case "promoteUser" -> promoteUser(data);
                case "demoteUser" -> demoteUser(data);
                case "removeUser" -> removeUser(data);
                case "addPost" -> addPost();
                case "editPost" -> editPost(data);
                case "deletePost" -> deletePost(data);
                case "deleteGroup" -> deleteGroup();
                case "approveUser" -> approveUser(data);
                case "declineUser" -> declineUser(data);
            }

        } else {
            throw new UnsupportedOperationException(action + " is not permitted");
        }

    }

    private void deletePost(String postId) {
    }

    private void editPost(String postId) {
    }

    private void addPost() {
    }

    private void removeUser(String userId) {
    }

    private void deleteGroup() {
    }

    private void demoteUser(String userId) {
    }

    private void promoteUser(String userId) {
    }

    private void approveUser(String userId) {
    }

    private void declineUser(String userId) {
    }
}
