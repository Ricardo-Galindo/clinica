package com.Squad03.demo.controllers;

import com.Squad03.demo.models.User;
import com.Squad03.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User newUser = userService.saveUser(user);
        return  ResponseEntity.ok(newUser);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable UUID id) throws Exception {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public User updateUserById(@PathVariable UUID id, @RequestBody User newUserData) throws Exception {
        return userService.updateUserById(id, newUserData);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable UUID id) throws Exception {
        userService.deleteUserById(id);
        return "Usuário com ID: " + id + " foi excluído com sucesso!";
    }


}
