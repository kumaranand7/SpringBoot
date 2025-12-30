package com.example.MyProject.Service;

import com.example.MyProject.Entity.User;
import com.example.MyProject.repository.UserRepository;
import com.example.MyProject.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Save user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by id
//    public User getUserById(int id) {
//        return userRepository.findById(id).orElse(null);
//    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found for id:" + id));
    }

    // Delete user
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User updateUser(int id, User newUserData) {

        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser == null) {
            return null;
        }

        existingUser.setName(newUserData.getName());
        existingUser.setEmail(newUserData.getEmail());

        return userRepository.save(existingUser);
    }


}
