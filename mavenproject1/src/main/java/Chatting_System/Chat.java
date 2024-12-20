/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Chatting_System;
import java.util.*;
/**
 *
 * @author AbdElrahman
 */
public interface Chat {
    void loadDatabase();

    void addMessage(String text, String sender);

    void loadChatHistory();

    ArrayList<Message> getMessages();
}
