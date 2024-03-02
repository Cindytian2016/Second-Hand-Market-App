package com.example.markets.User;

import com.example.markets.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Register a new user
    @PostMapping("/register")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<UserEntity> registerUser(@RequestParam String username, @RequestParam String password) {
        try {
            userService.register(username, password);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            // Assuming your exception handling is done here
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    // Fetch all users
    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    // Check if a username exists
    @GetMapping("/exists")
    public ResponseEntity<Boolean> existsByUsername(@RequestParam String username) {
        boolean exists = userService.existsByUsername(username);
        return ResponseEntity.ok(exists);
    }

    // Additional endpoints as needed...
}