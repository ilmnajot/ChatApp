package uz.ilmnajot.chatapp.service;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.ilmnajot.chatapp.entity.User;
import uz.ilmnajot.chatapp.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User registerUser(String username, String password) {
        if (userRepository.findUserByUserByUsername(username).isPresent()) {
            return null;
        } else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userRepository.save(user);
            return user;
        }
    }

    @Override
    public User login(String username, String password) {
        Optional<User> optionalUser = userRepository.findUserByUserByUsername(username);
        if (optionalUser.isEmpty() || !optionalUser.get().getPassword().equals(password)){
            return null;
        }else {
        return optionalUser.get();
         }
    }


}
