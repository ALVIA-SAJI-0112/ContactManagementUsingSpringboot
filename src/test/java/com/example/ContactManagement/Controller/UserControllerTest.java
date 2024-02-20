package com.example.ContactManagement.Controller;

import com.example.ContactManagement.Entity.UserObject;
import com.example.ContactManagement.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUserById() {
        // Mock repository behavior
        UserObject mockUser = new UserObject();
        mockUser.setId(1L);
        mockUser.setName("John");
        when(userRepository.findById(anyLong())).thenReturn(java.util.Optional.of(mockUser));

        // Call the controller method
        UserObject user = userController.getUserById(1L);

        // Verify the result
        assertNotNull(user);
        assertEquals("John", user.getName());
    }
    @Test
    public void testAddUser() {
        // Create a mock user
        UserObject mockUser = new UserObject();
        mockUser.setId(1L);
        mockUser.setName("John");

        // Mock repository behavior
        when(userRepository.save(any(UserObject.class))).thenReturn(mockUser);

        // Call the controller method
        UserObject savedUser = userController.addUser(mockUser);

        // Verify the result
        assertNotNull(savedUser);
        assertEquals("John", savedUser.getName());
    }

    @Test
    public void testUpdateUser() {
        // Create a mock user
        UserObject mockUser = new UserObject();
        mockUser.setId(1L);
        mockUser.setName("John");

        // Mock repository behavior
        when(userRepository.save(any(UserObject.class))).thenReturn(mockUser);

        // Call the controller method
        UserObject updatedUser = userController.updateUser(1L, mockUser);

        // Verify the result
        assertNotNull(updatedUser);
        assertEquals("John", updatedUser.getName());
    }

    @Test
    public void testDeleteUser() {
        // Call the controller method
        userController.deleteUser(1L);

        // Verify that userRepository.deleteById method is called once
        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testGetAllUsers() {
        // Create a list of mock users
        List<UserObject> mockUsers = new ArrayList<>();
        UserObject user1 = new UserObject();
        user1.setId(1L);
        user1.setName("John");
        mockUsers.add(user1);

        UserObject user2 = new UserObject();
        user2.setId(2L);
        user2.setName("Jane");
        mockUsers.add(user2);

        // Mock repository behavior
        when(userRepository.findAll()).thenReturn(mockUsers);

        // Call the controller method
        List<UserObject> users = userController.getAllUsers();

        // Verify the result
        assertNotNull(users);
        assertEquals(2, users.size());
        assertEquals("John", users.get(0).getName());
        assertEquals("Jane", users.get(1).getName());
    }
}