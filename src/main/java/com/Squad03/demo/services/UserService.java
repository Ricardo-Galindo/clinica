package com.Squad03.demo.services;
import com.Squad03.demo.models.User;
import com.Squad03.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(UUID id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new Exception("Usuário não encontrado com ID: " + id);
        }
    }


    public User updateUserById(UUID id, User newUserData) throws Exception {
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setName(newUserData.getName());
            userToUpdate.setEmail(newUserData.getEmail());

            return userRepository.save(userToUpdate);
        } else {
            throw new Exception("Usuário não encontrado com ID: " + id);
        }
    }


    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(UUID id) throws Exception {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new Exception("Usuário não encontrado com ID: " + id);
        }
    }

}

