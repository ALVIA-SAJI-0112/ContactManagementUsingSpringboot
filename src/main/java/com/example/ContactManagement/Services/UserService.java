package com.example.ContactManagement.Services;

import com.example.ContactManagement.Entity.UserObject;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserObject addUser(UserObject user);
    UserObject getUserById(Long id);
    UserObject updateUser(Long id, UserObject user);
    void deleteUser(Long id);
    List<UserObject> getAllUsers();

    UserObject save(UserObject user);
    Optional<UserObject> findById(Long id);
    void deleteById(Long id);
    List<UserObject> findAll();
}