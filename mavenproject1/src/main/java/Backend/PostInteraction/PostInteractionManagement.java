package Backend.PostInteraction;

import Backend.AccountManagement;
import Backend.User;

import java.util.ArrayList;
import java.util.List;

public class PostInteractionManagement {
    private String postAuthor;
    private String postId;
    private List<Comment> comments = new ArrayList<>();
    private List<Like> likes = new ArrayList<>();
    private List<InteractionObserver> observers = new ArrayList<>();

    public PostInteractionManagement(String postAuthor, String postId) {
        this.postAuthor = postAuthor;
        this.postId = postId;
        initialize(); // Load saved interactions for the given postId
    }

    public void initialize() {
        InteractionDatabase database = InteractionDatabase.getInstance();
        // filter by postId to load only relevant interactions
        comments = database.loadInteractions("comments.json", Comment.class)
                .stream()
                .filter(comment -> comment.getPostId() != null && comment.getPostId().equals(postId))
                .toList();
        likes = database.loadInteractions("likes.json", Like.class)
                .stream()
                .filter(like -> like.getPostId() != null && like.getPostId().equals(postId))
                .toList();
    }


    public void addObserver(InteractionObserver observer) {
        observers.add(observer);
    }

    public void setPostAuthor(String postAuthor) {
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

    public void saveInteractions() {
        InteractionDatabase database = InteractionDatabase.getInstance();
        database.saveInteractions(comments, "comments.json");
        database.saveInteractions(likes, "likes.json");
    }
    
    public List<Like> getLikes(){
        return likes;
    }
    
    public List<Comment> getComments(){
        return comments;
    }
    
    public void setLikes(List<Like> likes){
        this.likes = likes;
    }
    
    public void setComments(List<Comment> comments){
        this.comments = comments;
    }
    public void setPostId(String postId){
        this.postId = postId;
    }
    public String getPostId(){
        return this.postId;
    }
    public void setAuthorId(String authorid){
        this.postAuthor = authorid;
    }
    public String getAuthorId(){
        return this.postAuthor;
    }



}
