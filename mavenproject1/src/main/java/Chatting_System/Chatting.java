/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chatting_System;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AbdElrahman
 */
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
        this.fileName = users[0] + "," + users[1];
        loadDatabase();
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void loadDatabase() {
        File file = new File(fileName);
        try {
            if (!file.createNewFile()) {
                database = new MessageDatabase(file);
                messages = database.loadMessages();
            } else {
                database = new MessageDatabase(file);

            }
        } catch (IOException ex) {
            Logger.getLogger(Chatting.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addMessage(String text, String sender) {
        Message m = new TextMessage();
        m.setMessage(text);
        m.setSender(sender);
        messages.add(m);
        database.saveMessages(messages);
    }

    public void loadChatHistory() {
        messages = database.loadMessages();
    }
}
