/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author AbdElrahman
 */
public class FriendsDatabase {
    private Map<String, ArrayList<String>> friend=new HashMap<>(); 
   private static final String fileName = "friends.json";
     private static ObjectMapper objectMapper = new ObjectMapper();
    public void writeinFile(ArrayList<User>users) throws IOException{
    File file = new File(fileName);
    for(int i=0;i<users.size();i++){
        if(users.get(i).getFriends()!=null)
    friend.put(users.get(i).getUserId(),users.get(i).getFriends());

    }
        objectMapper.writeValue(file, friend);
    } 
     private static ArrayList<User> load() throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        return objectMapper.readValue(file, new TypeReference<ArrayList<User>>() {});
    }
}
