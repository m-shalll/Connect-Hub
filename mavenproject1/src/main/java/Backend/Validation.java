/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Validation {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    //Email validation
    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return Pattern.matches(EMAIL_REGEX, email);
    }
    public boolean uniqueUserId(String userId) throws IOException{
        AccountManagement manager=new AccountManagement();
        ArrayList<User> users=manager.loadUsers();
        for(User user:users){
            if(user.getUserId().equals(userId)){
                return false;
            }
        }
        return true;
    }
    public boolean uniqueEmail(String email) throws IOException{
        AccountManagement manager=new AccountManagement();
        ArrayList<User> users=manager.loadUsers();
        for(User user:users){
            if(user.getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }
}
