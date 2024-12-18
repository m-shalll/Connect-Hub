package Backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Group implements GroupInterface{

    private String name;
    private String description;
    private String groupPhoto;
    private String admin;
    private ArrayList<String> users = new ArrayList<>();
    private ArrayList<String> coAdmin = new ArrayList<>();
    private ArrayList<Post> groupPosts = new ArrayList<>();
    private Map<String, String> groupRequests = new HashMap<>();



    @Override
    public void setGroupRequests(Map<String, String> friendReq){ this.groupRequests = friendReq; }
    @Override
    public void setGroupPhoto(String groupPhoto) { this.groupPhoto = groupPhoto;}
    @Override
    public void setAdmin(String admin) { this.admin = admin; }
    @Override
    public void setUsers(ArrayList<String> normalUsers) { this.users = normalUsers; }
    @Override
    public void setCoAdmin(ArrayList<String> coAdmin) { this.coAdmin = coAdmin; }
    @Override
    public void setName(String name) { this.name = name; }
    @Override
    public void setDescription(String description) { this.description = description; }
    @Override
    public void setGroupPosts(ArrayList<Post> groupPosts) { this.groupPosts = groupPosts; }

    @Override
    public String getName() { return name; }
    @Override
    public String getDescription() { return description; }
    @Override
    public ArrayList<String> getCoAdmin() { return coAdmin;}
    @Override
    public ArrayList<String> getUsers() { return users; }
    @Override
    public String getAdmin() { return admin; }
    @Override
    public String getGroupPhoto() { return groupPhoto; }
    @Override
    public ArrayList<Post> getGroupPosts() { return groupPosts; }
    @Override
    public Map<String, String> getGroupRequests(){ return groupRequests; }
}
