package Backend.Roles;

import Backend.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        ArrayList<String> userids = userGroups.returnGroup(groupName).getUsers();
        for(String userString:userids){
            try {
               User currentUser = accManager.getUser(userString);
              Map<String,String> roles =  currentUser.getRoles();
              roles.remove(groupName);
              currentUser.setRoles(roles);
              ArrayList<User> users = accManager.loadUsers();
            for(User user: users){
                if(user.getUserId().equals(currentUser.getUserId()))
                    user=currentUser;
            }
            AccountManagement.saveUsers(users);
              
            } catch (IOException ex) {
                Logger.getLogger(AdminRole.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        groupManagement.deleteGroup(groupName);
    }

    private void demoteUser(String userId, String groupName) {
        try {
            User currentUser = accManager.getUser(userId);
            GroupInterface group = userGroups.returnGroup(groupName);
            Map<String,String> roles = currentUser.getRoles();
            if(roles.get(groupName).equals("CoAdminRole")) {
            roles.put(groupName, "NormalUserRole");
            currentUser.setRoles(roles);
            ArrayList<User> users = accManager.loadUsers();
            for(User user: users){
                if(user.getUserId().equals(userId))
                    user=currentUser;
            }
            AccountManagement.saveUsers(users);
            }
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void promoteUser(String userId, String groupName) {
        try {
            User currentUser = accManager.getUser(userId);
            GroupInterface group = userGroups.returnGroup(groupName);
            Map<String,String> roles = currentUser.getRoles();
            if(roles.get(groupName).equals("NormalUserRole")){
                roles.put(groupName, "CoAdminRole");
            currentUser.setRoles(roles);
            ArrayList<User> users = accManager.loadUsers();
            for(User user: users){
                if(user.getUserId().equals(userId))
                    user=currentUser;
            }
            AccountManagement.saveUsers(users);
            
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
