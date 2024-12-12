package Backend.Roles;

import Backend.*;
import java.util.Set;

public class NormalUserRole extends RoleDecorator {
    private UserGroupsInterface userGroups;
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
    }

    private void addPost(String userId, GroupInterface group, Content content) {
        Post p = (Post)ContentFactory.createContent("post");
        p.setContentPublisher(userId);
        p.setContent(content);
        group.getGroupPosts().add(p);
    }
}
