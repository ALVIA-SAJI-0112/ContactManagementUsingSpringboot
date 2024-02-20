package com.example.ContactManagement.Controller;

import com.example.ContactManagement.Entity.UserObject;
import com.example.ContactManagement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserObject addUser(@RequestBody UserObject user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public UserObject getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserObject updateUser(@PathVariable Long id, @RequestBody UserObject user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/all")
    public List<UserObject> getAllUsers() {
        return userService.getAllUsers();
    }
}