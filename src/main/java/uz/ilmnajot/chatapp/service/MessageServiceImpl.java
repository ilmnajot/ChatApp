package uz.ilmnajot.chatapp.service;

import org.springframework.stereotype.Service;
import uz.ilmnajot.chatapp.entity.Message;
import uz.ilmnajot.chatapp.repository.MessageRepository;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message send(String content, String sender) {
        Message message = new Message();
        message.setContent(content);
        message.setSender(sender);
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getAllMessage() {
        return messageRepository.findAll();
    }
}
