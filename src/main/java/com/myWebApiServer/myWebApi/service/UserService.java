package com.myWebApiServer.myWebApi.service;

import com.myWebApiServer.myWebApi.dto.CreateUserRequest;
import com.myWebApiServer.myWebApi.model.User;
import com.myWebApiServer.myWebApi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getByUsername(String tcIdNumber) {
        return userRepository.findByTcIdNumber(tcIdNumber);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public void create(CreateUserRequest createUserRequest) {
        User createdUser = new User();
        createdUser.setName(createUserRequest.getName());
        createdUser.setSurname(createUserRequest.getSurname());
        createdUser.setTcIdNumber(createUserRequest.getTcIdNumber());
        createdUser.setPassword(createUserRequest.getPassword());
        createdUser.setAuthorities(createUserRequest.getAuthorities());
        userRepository.save(createdUser);
    }
}
