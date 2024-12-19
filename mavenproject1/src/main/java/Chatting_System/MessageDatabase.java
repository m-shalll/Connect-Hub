
package Chatting_System;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class MessageDatabase {
        private  File file;
    
    public MessageDatabase(File file){
        this.file=file;
    }
    public void saveMessages(ArrayList<Message> m) {
    
    try {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, m);
    } catch (IOException e) {

    }
}
    public ArrayList<Message> loadMessages() {
        
        ArrayList<Message> messages = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("File not found: " );
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
