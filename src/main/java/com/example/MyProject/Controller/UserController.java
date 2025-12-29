package com.example.MyProject.Controller;

import com.example.MyProject.Entity.User;
import com.example.MyProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
        | Method | URL           | Kaam     |
        | ------ | ------------- | -------- |
        | POST   | `/users`      | Create   |
        | GET    | `/users`      | Read all |
        | GET    | `/users/{id}` | Read one |
        | PUT    | `/users/{id}` | Update   |
        | DELETE | `/users/{id}` | Delete   |

*/

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // POST - save user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // GET - all users
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    // GET - user by id
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    // DELETE - user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "User deleted";
    }


    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id,
                           @RequestBody User user) {
        return userService.updateUser(id, user);
    }

}

