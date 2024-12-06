package Backend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ProfileManagement {
    private final String userId;
    private String userPhoto;
    private String userCover;
    private String userBio;
    private String userPassword;
    private PasswordManager passwordManager = PasswordManager.getInstance();
    private AccountManagement accManager = new AccountManagement();


    public ProfileManagement(String userId, String userPhoto, String userCover, String userBio, String userPassword) {
        this.userId = userId;
        this.userPhoto = userPhoto;
        this.userCover = userCover;
        this.userBio = userBio;
        this.userPassword = userPassword;
    }


    public void SaveDetails() {
        try {
            ArrayList<User> users = accManager.loadUsers();
            
            User neededUser = null;
            //iterate through the list till user is found
            for (User user : users) {
                if (user.getUserId().equals(userId)) {
                    neededUser = user;
                    break;
                }
            }
            if (neededUser != null) {
                if (userPhoto != null) {
                    neededUser.setUserPhoto(userPhoto);
                }
                if (userCover != null) {
                    neededUser.setUserCover(userCover);
                }
                if (userBio != null) {
                    neededUser.setUserBio(userBio);
                }
                if (userPassword != null) {
                  
                    neededUser.setSalt(passwordManager.generateSalt(16));
                    neededUser.setPassword(passwordManager.returnHashed(userPassword, neededUser.getSalt()));
                }
                AccountManagement.saveUsers(users);
                
            } else {
                System.out.println("User not found ");
            }

        } catch (Exception e) {
            System.out.println(e + "error");
        }
    }
    
    //friendlist

    public ArrayList<Post> profileFeed() {
        try {
            //Reads the json file into a list of User objects
            PostDatabase postdatabase = PostDatabase.getInstance();
            ArrayList<Post> allPosts = postdatabase.loadPosts();
            ArrayList<Post> userPosts = new ArrayList<>();
            if (allPosts != null) {
                for (Post post : allPosts) {
                    if (post.getContentPublisher().equals(userId)) {
                        userPosts.add(post);
                    }
                }
                return userPosts;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}