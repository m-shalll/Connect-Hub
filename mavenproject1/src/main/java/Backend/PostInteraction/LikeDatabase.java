package Backend.PostInteraction;

import Backend.Post;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LikeDatabase {
    private static LikeDatabase instance = null;

    private LikeDatabase(){

    }
    public static LikeDatabase getInstance(){
        if(instance == null){
            instance  = new LikeDatabase();
        }
        return instance;
    }
    public void saveInteractions(ArrayList<Like> likes) {
        File file = new File("likes.json");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, likes);
        } catch (IOException e) {
            System.err.println("Error saving interactions: " + e.getMessage());
        }
    }

    // Load interactions from a file
    public ArrayList<Like> loadInteractions() {
        File file = new File("likes.json");
        ArrayList<Like> likes = new ArrayList<>();

        if (!file.exists()) {
            System.err.println("File not found: " + "likes.json");
            return likes;
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            likes = objectMapper.readValue(file,objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Like.class));
        } catch (IOException e) {
            System.out.println("Error in loading posts " + e.getMessage());
        }
        return likes;
    }
}





