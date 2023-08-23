package uz.ilmnajot.chatapp.service;

import uz.ilmnajot.chatapp.entity.Message;

import java.util.List;

public interface MessageService {
    Message send(String content, String sender);

    List<Message> getAllMessage();
}
