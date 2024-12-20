
package Chatting_System;
import Backend.notifications.ChatNoti;
import Backend.notifications.NotificationManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chatting implements Chat{

    private String sender;
    private String reciever;
    private String fileName;
    private ArrayList<Message> messages;
    private MessageDatabase database;

    public Chatting(String sender, String reciever) {
        this.sender = sender;
        this.reciever = reciever;
        messages = new ArrayList<>();
        String[] users = {sender, reciever};
        Arrays.sort(users);
        this.fileName = users[0] + "," + users[1] + ".json";
        loadDatabase();
    }
    @Override
    public String getReciever() {
        return reciever;
    }

    @Override
    public ArrayList<Message> getMessages() {
        return messages;
    }

    @Override
    public void loadDatabase() {
    File file = new File(fileName);
    ObjectMapper objectMapper = new ObjectMapper();
    try {
        if (!file.createNewFile()) {
            database = new MessageDatabase(file);
            messages = database.loadMessages();
        } else {
            ArrayNode emptyArray = objectMapper.createArrayNode(); 
            try {
                objectMapper.writeValue(file, emptyArray);
            } catch (IOException ex) {
                throw new IOException("Failed to initialize new file with empty array", ex);
            }
            database = new MessageDatabase(file);
        }
    } catch (IOException ex) {
        System.err.println("Error handling the file: " + ex.getMessage());
    }
}

    @Override
    public void addMessage(String text, String sender) {
        Message m = new TextMessage();
        m.setMessage(text);
        m.setSender(sender);
        messages.add(m);
        database.saveMessages(messages);
        NotificationManager noti=new NotificationManager();        
        ChatNoti not2=new ChatNoti();
        not2.setMessage();
        not2.setUserId(this.reciever);
        not2.setSecondUser(this.sender);
        try {
            ArrayList allNotis = noti.load();
            allNotis.add(not2);
            noti.save(allNotis);
        } catch (IOException ex) {
            Logger.getLogger(Chatting.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void loadChatHistory() {
        messages = database.loadMessages();
    }
}
