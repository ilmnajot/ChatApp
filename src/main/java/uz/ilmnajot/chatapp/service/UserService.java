package uz.ilmnajot.chatapp.service;

import uz.ilmnajot.chatapp.entity.User;

public interface UserService {
    User registerUser(String username, String password);
    User login(String username, String password);
}
