package Backend.PostInteraction;

import Backend.AccountManagement;
import Backend.User;

import java.util.ArrayList;
import java.util.List;

public class PostInteractionManagement {
    private User postAuthor;
    private List<Comment> comments = new ArrayList<>();
    private List<Like> likes = new ArrayList<>();
    private static PostInteractionManagement instance;
    private List<InteractionObserver> observers = new ArrayList<>();

    //Singleton
    public static PostInteractionManagement getInstance() {
        if (instance == null) {
            instance = new PostInteractionManagement();
        }
        return instance;
    }

    public void addObserver(InteractionObserver observer) {
        observers.add(observer);
    }

    public void setPostAuthor(User postAuthor) {
        this.postAuthor = postAuthor;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        notifyObservers(comment.getUsername() + " added a comment to your post: " + comment.getText());
    }

    public void LikePost(Like like){
        likes.add(like);
        notifyObservers(like.getUsername() + "liked your post");
    }

    public void UnLikePost(Like like){
        likes.remove(like);
    }

    public void notifyObservers(String message){
    for(InteractionObserver observer : observers){
        observer.notify(message);
    }
    }
}
