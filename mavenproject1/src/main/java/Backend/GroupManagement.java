
package Backend;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GroupManagement {
    private static GroupManagement instance = null;
    private static final String fileName = "Groups";
    
    private GroupManagement(){}
    public static GroupManagement getInstance(){
        if(instance == null){
            instance = new GroupManagement();
        }
        return instance;
    }
    public ArrayList<GroupInterface> loadGroups(){
        File file = new File(fileName);
        ArrayList<GroupInterface> groups = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return groups; 
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            groups = objectMapper.readValue(file,objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Group.class));
        } catch (IOException e) {
            System.out.println("Error in loading posts " + e.getMessage());
        }
        return groups; 
    }
    public void saveGroups(ArrayList<GroupInterface> groups) {
        File f = new File(fileName);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(f, groups);
        } catch (IOException e) {

        }
    }
    public GroupInterface createGroup(String admin, String name){
        GroupInterface newGroup = new Group();
        newGroup.setAdmin(admin);
        newGroup.setName(name);
        return newGroup;
    }

    public void deleteGroup(String groupId){
        ArrayList<GroupInterface> groups = loadGroups();
        for (int i = 0; i < groups.size(); i++) {
            if(groups.get(i).getName().equals(groupId)){
                groups.remove(groups.get(i));
                saveGroups(groups);
                return;
            }
        }
    }

}
