package Backend.PostInteraction;

import Backend.ContentCreation;
import Backend.Post;
import Backend.PostDatabase;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InteractionDatabase {
    private static InteractionDatabase instance = null;

    private InteractionDatabase(){

    }
    public static InteractionDatabase getInstance(){
        if(instance == null){
            instance  = new InteractionDatabase();
        }
        return instance;
    }
    public void saveInteractions(List<?> interactions, String filename) {
        File file = new File(filename);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, interactions);
        } catch (IOException e) {
            System.err.println("Error saving interactions: " + e.getMessage());
        }
    }
    public <T> List<T> loadInteractions(String filename, Class<T> type) {
        File file = new File(filename);
        List<T> interactions = new ArrayList<>();
        if (!file.exists()) {
            System.err.println("File not found: " + filename);
            return interactions;
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            interactions = objectMapper.readValue(file,
                    objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, type));
        } catch (IOException e) {
            System.err.println("Error loading interactions: " + e.getMessage());
        }
        return interactions;
    }



}
