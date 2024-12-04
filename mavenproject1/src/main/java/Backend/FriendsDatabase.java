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
   private static final String fileName = "friends.json";
     private static ObjectMapper objectMapper = new ObjectMapper();
    public void writeinFile(ArrayList<User> friends) throws IOException{
    File file = new File(fileName);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, friends);
    } 
     private static ArrayList<User> load() throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        return objectMapper.readValue(file, new TypeReference<ArrayList<User>>() {});
    }
}
