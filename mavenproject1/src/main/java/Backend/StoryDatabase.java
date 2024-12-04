
package Backend;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class StoryDatabase {
    private static final String fileName = "Stories.json";
    private static StoryDatabase instance = null;
    
    private StoryDatabase(){
        
    }
    public static StoryDatabase getInstance(){
        if(instance == null){
            instance  = new StoryDatabase();
        }
        return instance;
    }
    public void savePosts(ArrayList<Story> p) {
    File f = new File(fileName);
    try {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(f, p);
    } catch (IOException e) {

    }
}
    public ArrayList<Story> loadPosts(){
        File f = new File(fileName);
        if (f.exists()) {
            ArrayList<Story> s = new ArrayList<>();
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                s = objectMapper.readValue(f, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Story.class));
            } catch (IOException e) {

            }
            return s;
        }
        return null;  
    }
}

