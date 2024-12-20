package Backend.PostInteraction;

import Backend.Post;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommentDatabase {
    private static CommentDatabase instance = null;

    private CommentDatabase(){

    }
    public static CommentDatabase getInstance(){
        if(instance == null){
            instance  = new CommentDatabase();
        }
        return instance;
    }
    public void saveInteractions(ArrayList<Comment> comments) {
        File file = new File("comments.json");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, comments);
        } catch (IOException e) {
            System.err.println("Error saving interactions: " + e.getMessage());
        }
    }

    // Load interactions from a file
    public ArrayList<Comment> loadInteractions() {
    File file = new File("comments.json");
    ArrayList<Comment> comments = new ArrayList<>();

    if (!file.exists()) {
        System.err.println("File not found: " + "comments.json");
        return comments;
    }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            comments = objectMapper.readValue(file,objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Comment.class));
        } catch (IOException e) {
            System.out.println("Error in loading posts " + e.getMessage());
        }
        return comments;
    }




}
