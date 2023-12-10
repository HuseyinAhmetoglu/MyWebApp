package com.myWebApiServer.myWebApi.controller;

import com.myWebApiServer.myWebApi.dto.CreateUserRequest;
import com.myWebApiServer.myWebApi.model.User;
import com.myWebApiServer.myWebApi.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity getUserById(@PathVariable("userId") Long userId) {
        Optional<User> user = userService.getUserById(userId);
        return ResponseEntity.ok(user.orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı!")));
    }

    @GetMapping("/all")
    public ResponseEntity getAllUser() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty())
            throw new EntityNotFoundException("Hiç kayıt yok!");
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody CreateUserRequest createUserRequest) {
        userService.create(createUserRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
