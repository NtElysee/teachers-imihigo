package com.inspection.serviceLayer;

import com.inspection.model.User;
import com.inspection.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User registerUser(String login, String password, String email) {
        if (login == null || password == null) {
            return null;

        } else {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            return userRepository.save(user);
        }
    }


    public User authenticate(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmailAndPassword(email, password);
        return userOptional.isPresent() ? userOptional.get() : null;
    }
}



