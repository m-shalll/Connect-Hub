
package Backend;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PostDatabase {
    private static final String fileName = "Posts.json";
    private static PostDatabase instance = null;
    
    private PostDatabase(){
        
    }
    public static PostDatabase getInstance(){
        if(instance == null){
            instance  = new PostDatabase();
        }
        return instance;
    }
    public void savePosts(ArrayList<ContentCreation> p) {
    File f = new File(fileName);
    try {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(f, p);
    } catch (IOException e) {

    }
}
    public ArrayList<ContentCreation> loadPosts() {
        File file = new File(fileName);
        ArrayList<ContentCreation> posts = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return posts; 
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            posts = objectMapper.readValue(file,objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Post.class));
        } catch (IOException e) {
            System.out.println("Error in loading posts " + e.getMessage());
        }
        return posts; 
    }
}
    

