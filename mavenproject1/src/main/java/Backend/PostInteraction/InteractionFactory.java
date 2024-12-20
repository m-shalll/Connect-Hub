package Backend.PostInteraction;

import Backend.ContentCreation;
import Backend.Post;
import Backend.Story;

import java.time.LocalDateTime;

public class InteractionFactory {

    public static Comment createComment(String text, String postId, String username) {
        String commentId = generateUniqueId();
        return new Comment(text, postId, username, LocalDateTime.now());
    }

    public static Like createLike(String postId, String username) {
        return new Like(postId, username, LocalDateTime.now());
    }

    private static String generateUniqueId() {
        return "ID_" + System.currentTimeMillis(); // Simple unique ID generator
    }
}

