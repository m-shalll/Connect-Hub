/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Chatting_System;

import java.time.LocalDateTime;

/**
 *
 * @author AbdElrahman
 */
public interface Message {
        public String getMessage();

    public void setMessage(String message);

    public String getSender();

    public void setSender(String sender);
      
    public String getReciever();

    public void setReciever(String sender);

    public LocalDateTime getTimeStamp();

    public void setTimeStamp(LocalDateTime timeStamp);
}
