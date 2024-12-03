package Backend;

public class User {
    String userId;
    String Email;
    String userName;
    String password;
    String dateOfBirth;
    String status;

    public User(String password, String email, String status, String dateOfBirth, String userName, String userId) {
        this.password = password;
        Email = email;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
        this.userName = userName;
        this.userId = userId;
    }
}
