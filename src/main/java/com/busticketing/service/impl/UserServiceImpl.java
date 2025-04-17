package com.busticketing.service.impl;

import com.busticketing.repository.UserRepository;
import com.busticketing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.busticketing.model.User;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public User registerUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean validateUser(User user, String password) {
        Optional<User> storedUser = findByUsername(user.getUsername());
        return storedUser.isPresent() && bCryptPasswordEncoder.matches(password, storedUser.get().getPassword());
    }

}
