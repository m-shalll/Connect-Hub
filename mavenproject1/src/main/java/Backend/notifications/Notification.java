package Backend.notifications;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME, // Use the type name for identifying the subclass
    include = JsonTypeInfo.As.PROPERTY, // Include the type info as a property
    property = "type" // The property in JSON that specifies the type
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = FriendRequests.class, name = "Friend"),
    @JsonSubTypes.Type(value = NewUser.class, name = "User"),
    @JsonSubTypes.Type(value = NewPosts.class, name = "Post"),
    @JsonSubTypes.Type(value = NewStatus.class, name = "Status"),
    @JsonSubTypes.Type(value = ChatNoti.class, name = "ChatNoti")
})
public abstract class Notification {
    String message;
    String type;
    private String userId;
    double notificationId;
    public Notification(){
        
    }
    
    public String getUserId(){
        return this.userId;
    }
    public void setUserId(String id){
        this.userId=id;
    }
    public String getMessage(){
        return this.message;
    }
    public void setNotificationId(double notificationId){
        this.notificationId=notificationId;
    }
    public double getNotificationId(){
        return this.notificationId;
    }
    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type=type;
    }
    public abstract void setMessage();
    
}
