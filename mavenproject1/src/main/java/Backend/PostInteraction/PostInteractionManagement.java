package Backend.PostInteraction;

import Backend.AccountManagement;
import Backend.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostInteractionManagement {

    private String postAuthor;
    private String postId;
    private ArrayList<Comment> comments = new ArrayList<>();
    private ArrayList<Like> likes = new ArrayList<>();
    private List<InteractionObserver> observers = new ArrayList<>();

    public PostInteractionManagement(String postAuthor, String postId) {
        this.postAuthor = postAuthor;
        this.postId = postId;
        initialize(); // Load saved interactions for the given postId
    }

 public void initialize() {
    // Load all interactions (likes and comments) for the post
    CommentDatabase commentatabase = CommentDatabase.getInstance();
     LikeDatabase likeatabase = LikeDatabase.getInstance();
    
    // Load and filter likes for the selected postId
    this.likes = likeatabase.loadInteractions();
    // Load and filter comments for the selected postId
    this.comments = commentatabase.loadInteractions();
}


    public void addObserver(InteractionObserver observer) {
        observers.add(observer);
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void LikePost(Like newLike) {
    // Avoid modifying during iteration
    boolean alreadyLiked = false;
    for (Like like : likes) {
        if (like.getPostId().equals(newLike.getPostId()) && 
            like.getUsername().equals(newLike.getUsername())) {
            alreadyLiked = true;
            break;
        }
    }
    if (!alreadyLiked) {
        likes.add(newLike);
    }
}


    public void UnLikePost(Like newLike) {
    for (int i = 0; i < likes.size(); i++) {
        Like like = likes.get(i);
        if (like.getPostId().equals(newLike.getPostId()) &&
            like.getUsername().equals(newLike.getUsername())) {
            likes.remove(i); // Remove the matching Like object by index
            break; // Exit the loop once the item is removed
        }
    }
}


    public void saveInteractions() {

        CommentDatabase commentatabase = CommentDatabase.getInstance();
        LikeDatabase likeatabase = LikeDatabase.getInstance();

        likeatabase.saveInteractions(likes);

        // Save the comments as well (if any changes to them)
        commentatabase.saveInteractions(comments);
    }

    public ArrayList<Like> getLikes() {
        return likes;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setLikes(ArrayList<Like> likes) {
        this.likes = likes;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostId() {
        return this.postId;
    }

    public void setAuthorId(String authorid) {
        this.postAuthor = authorid;
    }

    public String getAuthorId() {
        return this.postAuthor;
    }

}
