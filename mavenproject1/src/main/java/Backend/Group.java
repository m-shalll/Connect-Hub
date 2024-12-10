package Backend;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements GroupInterface{

    private String name;
    private String description;
    private String groupPhoto;
    private String admin;
    private ArrayList<String> normalUsers;
    private ArrayList<String> coAdmin;
    private ArrayList<ContentCreation> groupPosts;


    public void setGroupPhoto(String groupPhoto) { this.groupPhoto = groupPhoto;}
    public void setAdmin(String admin) { this.admin = admin; }
    public void setNormalUsers(ArrayList<String> normalUsers) { this.normalUsers = normalUsers; }
    public void setCoAdmin(ArrayList<String> coAdmin) { this.coAdmin = coAdmin; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setGroupPosts(ArrayList<ContentCreation> groupPosts) { this.groupPosts = groupPosts; }

    public String getName() { return name; }
    public ArrayList<String> getCoAdmin() { return coAdmin;}
    public ArrayList<String> getNormalUsers() { return normalUsers; }
    public ArrayList<String> getAdmin() { return coAdmin; }
    public String getGroupPhoto() { return groupPhoto; }
    public ArrayList<ContentCreation> getGroupPosts() { return groupPosts; }
}
