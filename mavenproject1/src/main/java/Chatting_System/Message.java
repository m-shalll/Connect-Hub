
package Chatting_System;
import java.time.LocalDateTime;

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
