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
    private PasswordManager passwordManager;


    public ProfileManagement(String userId, String userPhoto, String userCover, String userBio, String userPassword) {
        this.userId = userId;
        this.userPhoto = userPhoto;
        this.userCover = userCover;
        this.userBio = userBio;
        this.userPassword = userPassword;
    }


    private void SaveDetails(String userId) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            //Reads the json file into a list of User objects
            List<User> users = mapper.readValue(
                    new File("User.json"),
                    new TypeReference<List<User>>() {
                    }
            );
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
                    neededUser.setSalt();
                    neededUser.setPassword(passwordManager.returnHashed(userPassword, neededUser.getSalt()));
                }
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File("User.json"), users);
            } else {
                System.out.println("User not found ");
            }

        } catch (Exception e) {
            System.out.println(e + "error");
        }
    }

    private ArrayList<Post> profileFeed() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            //Reads the json file into a list of User objects
            ArrayList<Post> users = mapper.readValue(
                    new File("Posts.json"),
                    new TypeReference<ArrayList<Post>>() {
                    }
            );
            ArrayList<Post> userPosts = new ArrayList<>();
            if (users != null) {
                for (Post post : users) {
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