/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chatting_System;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author AbdElrahman
 */
public class MessageDatabase {
        private  String fileName;
    private static MessageDatabase instance = null;
    
    private MessageDatabase(String s1,String s2){
        fileName=s1+","+s2;
    }
    public static MessageDatabase getInstance(String s1,String s2){
        if(instance == null){
            instance  = new MessageDatabase(s1,s2);
        }
        return instance;
    }
    public void savePosts(ArrayList<TextMessage> m) {
    File f = new File(fileName);
    try {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(f, m);
    } catch (IOException e) {

    }
}
    public ArrayList<TextMessage> loadPosts() {
        File file = new File(fileName);
        ArrayList<TextMessage> messages = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return messages; 
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            messages = objectMapper.readValue(file,objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, TextMessage.class));
        } catch (IOException e) {
            System.out.println("Error in loading messages " + e.getMessage());
        }
        return messages; 
    }
}
