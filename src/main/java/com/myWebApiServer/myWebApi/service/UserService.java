package com.myWebApiServer.myWebApi.service;

import com.myWebApiServer.myWebApi.dto.CreateUserRequest;
import com.myWebApiServer.myWebApi.dto.UserResponse;
import com.myWebApiServer.myWebApi.model.User;
import com.myWebApiServer.myWebApi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public UserResponse createUser(CreateUserRequest createUserRequest) {
        User createdUser = new User();
        createdUser.setName(createUserRequest.getName());
        createdUser.setSurname(createUserRequest.getSurname());
        createdUser.setUsername(createUserRequest.getUsername());
        createdUser.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        createdUser.setAuthorities(createUserRequest.getAuthorities());
        userRepository.save(createdUser);
        return new UserResponse(createdUser);
    }
}
