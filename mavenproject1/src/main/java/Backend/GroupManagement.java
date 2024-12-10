package Backend;

import java.util.ArrayList;

public class GroupManagement {
    private static GroupManagement instance = null;
    private GroupManagement(){}
    public static GroupManagement getInstance(){
        if(instance == null){
            instance = new GroupManagement();
        }
        return instance;
    }

    public void saveGroups(ArrayList<GroupInterface> groups){}

    public ArrayList<GroupInterface> loadGroups(){}

    public ArrayList<String> listGroups(String userId){} // may create a class `userGroups` to implement this along other features.

    public GroupInterface createGroup(String admin, String name){
        GroupInterface newGroup = new Group();
        newGroup.setAdmin(admin);
        newGroup.setName(name);
        return newGroup;
    }

    public void deleteGroup(String groupId){}
}
