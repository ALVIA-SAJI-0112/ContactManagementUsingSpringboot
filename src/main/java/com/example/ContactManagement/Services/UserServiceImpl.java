package com.example.ContactManagement.Services;

import com.example.ContactManagement.Entity.UserObject;
import com.example.ContactManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserObject addUser(UserObject user) {
        return userRepository.save(user);
    }

    @Override
    public UserObject getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserObject updateUser(Long id, UserObject user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserObject> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserObject save(UserObject user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<UserObject> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserObject> findAll() {
        return userRepository.findAll();
    }
}