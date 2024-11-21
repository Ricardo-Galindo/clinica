package com.Squad03.demo.controllers;
import com.Squad03.demo.dto.UserResponseDTO;
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
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody User user){
        User newUser = userService.saveUser(user);
        UserResponseDTO dto = userService.convertToResponseDTO(newUser);
        return  ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable UUID id){
        User currentUser = userService.getUserById(id);
        UserResponseDTO dto = userService.convertToResponseDTO(currentUser);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> allUsers = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUserById(@PathVariable UUID id, @RequestBody User newUserData){
        User updatedUser = userService.updateUserById(id, newUserData);
        UserResponseDTO dto = userService.convertToResponseDTO(updatedUser);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable UUID id) throws Exception {
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário com ID: " + id + " foi excluído com sucesso!");
    }
}
