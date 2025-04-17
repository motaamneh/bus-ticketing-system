package com.busticketing.service;
import com.busticketing.model.User;
import java.util.Optional;
public interface UserService {
    User registerUser(User user);
    Optional<User> findByUsername(String username);
    boolean validateUser(User user, String password);

}
