
package Backend;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class UserGroups implements UserGroupsInterface{
    private GroupManagement database = GroupManagement.getInstance();
    private ArrayList<GroupInterface> groups;
    
    @Override
    public ArrayList<String> returnAllGroupNames(){
        ArrayList<String> groupNames = new ArrayList<>();
        groups = database.loadGroups();
        for(int i = 0; i<groups.size(); i++){
            groupNames.add(groups.get(i).getName());
        }
        return groupNames;
    }
    @Override
    public ArrayList<String> returnGroupNamesByUserId(String userId){
        ArrayList<String> groupNames = new ArrayList<>();
        groups = database.loadGroups();
        for(int i = 0; i<groups.size(); i++){
            ArrayList<String> currentGroupUsers = groups.get(i).getUsers();
            for(int j = 0; j < currentGroupUsers.size() ; j++){
                if(currentGroupUsers.get(j).equals(userId)){
                    groupNames.add(groups.get(i).getName());
                    break;
                }
            }
        }
        return groupNames;
    }
    @Override
    public ArrayList<GroupInterface> returnGroupsByUserId(String userId){
        ArrayList<GroupInterface> userGroups= new ArrayList<>();
        groups = database.loadGroups();
        for(int i = 0; i<groups.size(); i++){
            ArrayList<String> currentGroupUsers = groups.get(i).getUsers();
            for(int j = 0; j < currentGroupUsers.size() ; j++){
                if(currentGroupUsers.get(j).equals(userId)){
                    userGroups.add(groups.get(i));
                    break;
                }
            }
        }
        return userGroups;
    }
    @Override
    public GroupInterface returnGroup(String groupName){
        groups = database.loadGroups();
        for(int i=0; i<groups.size(); i++){
            if(groups.get(i).getName().equals(groupName)){
                return groups.get(i);
            }
        }
        return null;
    }
    @Override
    public boolean isUserinGroup(String userId, GroupInterface currentGroup){
        ArrayList<String> usersInGroup = currentGroup.getUsers();
        for(int i=0; i<usersInGroup.size(); i++){
            if(usersInGroup.get(i).equals(userId)){
                return true;
            }
        }
        return false;
    }
    @Override
    public void addUserToGroup(String userId, GroupInterface currentGroup){
        ArrayList<String> groupUsers = currentGroup.getUsers();
        if(groupUsers == null){
            groupUsers = new ArrayList<>();
            groupUsers.add(userId);
            currentGroup.setUsers(groupUsers);
        } else if(!isUserinGroup(userId, currentGroup)){
            groupUsers.add(userId);
            currentGroup.setUsers(groupUsers);
        }
    }
    @Override
    public void removeUserfromGroup(String userId, GroupInterface currentGroup){
        if(isUserinGroup(userId, currentGroup)){
            currentGroup.getUsers().remove(userId);
        }
    }
    @Override
    public void sendGroupRequest(User user, GroupInterface group) {
        Map<String, String> grouprequests = group.getGroupRequests();

        if (grouprequests.containsKey(user.getUserId())) {
            String status = grouprequests.get(user.getUserId());
            if (!status.equals("declined"))
                JOptionPane.showMessageDialog(null,"You have already been declined from this group ","Notice", JOptionPane.INFORMATION_MESSAGE);
        }
        group.getGroupRequests().put(user.getUserId(), "pending");
    }
}
