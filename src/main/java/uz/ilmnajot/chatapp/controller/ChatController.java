package uz.ilmnajot.chatapp.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ilmnajot.chatapp.entity.Message;
import uz.ilmnajot.chatapp.entity.User;
import uz.ilmnajot.chatapp.service.MessageService;
import uz.ilmnajot.chatapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class ChatController {
    private final UserService userService;
    private final MessageService messageService;

    public ChatController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }
    @PostMapping("/register")
    public HttpEntity<User> saveUser(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.ok(userService.registerUser(username, password));
    }
    @PostMapping("/login")
    public HttpEntity<String> login(@RequestParam String username, @RequestParam String password) {
        User login = userService.login(username, password);
        return ResponseEntity.ok("login successful");
    }
    @PostMapping("/send")
    public HttpEntity<String> send(@RequestParam String content, @RequestParam String sender) {
        messageService.send(content, sender);
        return ResponseEntity.ok("send successful");
    }
    @GetMapping("/all")
    public HttpEntity<List<Message>> getAll(){
        List<Message> allMessage = messageService.getAllMessage();
        return ResponseEntity.ok(allMessage);
    }

}
