package Backend;

import java.util.Set;

public class CoAdminRole implements Role{
    private final Set<String> allowedActions = Set.of(
            "removeUser", "addPost", "editPost", "deletePost", "approveUser", "declineUser", "leaveGroup"
    );
    @Override
    public boolean canPerform(String action) {
        return false;
    }

    @Override
    public void execute(String action, String data) {

    }

    private void leaveGroup() {
    }

    private void deletePost(String postId) {
    }

    private void editPost(String postId) {
    }

    private void addPost() {
    }

    private void removeUser(String userId) {
    }

    private void approveUser(String userId) {
    }

    private void declineUser(String userId) {
    }

}
