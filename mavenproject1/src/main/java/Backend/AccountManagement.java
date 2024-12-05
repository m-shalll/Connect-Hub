package Backend;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AccountManagement {
    private static final String fileName = "users.json";
    private ArrayList<User> users=new ArrayList<>();
    private static ObjectMapper objectMapper = new ObjectMapper();

    // signup method creates a user object and adds it to json file
    public void signUp(String password, String email, String dateOfBirth, String userName, String userId){
        User newUser = new UserBuilder()
                .setSalt()
                .setPassword(password)
                .setEmail(email)
                .setDateOfBirth(dateOfBirth)
                .setName(userId)
                .setId(userId)
                .build();
        this.users.add(newUser);
        try {
            saveUsers(this.users);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // login method changes status to online
    public boolean logIn(String userId) throws IOException {
        ArrayList<User> users=loadUsers();
        for(User user:users){
            if(user.getUserId().equals(userId)){
                user.setStatusOn();
                saveUsers(users);
                return true;
            }
        }
        return false;
    }
    // logout method changes status to offline
    public void logOut(String userId) throws IOException {
        ArrayList<User> users=loadUsers();
        for(User user:users){
            if(user.getUserId().equals(userId)){
                user.setStatusOff();
                saveUsers(users);
            }
        }
    }
    // loadUsers methods returns arraylist of all the users from json file
    public static ArrayList<User> loadUsers() throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        return objectMapper.readValue(file, new TypeReference<ArrayList<User>>() {});
    }
    // saveUsers methods takes arraylist of users and saves them in json file
    public static void saveUsers(ArrayList<User> users) throws IOException {
        File file = new File(fileName);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, users);
    }
    public User getUser(String username){
        for(User user:users){
            if(user.getUserName().equals(username))
            return user;
        }
        return null;
    }
}
