package com.Squad03.demo.controllers;
import com.Squad03.demo.models.User;
import com.Squad03.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
        return  ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id){
        User currentUser = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(currentUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable UUID id, @RequestBody User newUserData){
        User updatedUser = userService.updateUserById(id, newUserData);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable UUID id) throws Exception {
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuário com ID: " + id + " foi excluído com sucesso!");
    }


}
