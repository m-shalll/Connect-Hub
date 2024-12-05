
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
    public void savePosts(ArrayList<Post> p) {
    File f = new File(fileName);
    try {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(f, p);
    } catch (IOException e) {

    }
}
    public ArrayList<Post> loadPosts(){
        File f = new File(fileName);
        if (f.exists()) {
            ArrayList<Post> p = new ArrayList<>();
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                p = objectMapper.readValue(f, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Post.class));
            } catch (IOException e) {
                
            }
            return p;
        }
        return null;  
    }
}
    

