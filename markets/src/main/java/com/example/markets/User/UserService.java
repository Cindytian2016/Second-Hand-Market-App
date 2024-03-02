package com.example.markets.User;

import com.example.markets.Entity.UserEntity;
import com.example.markets.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Transactional
    public void register(String username, String password) {
        UserEntity existingUser=userRepository.findByUsername(username);
        if(existingUser!=null){
            throw new UserAlreadyExistException("User " + username + " already exists");

        }

        UserEntity newuser=new UserEntity(null,username,password);
        this.saveUser(newuser);
    }

    // Create or update a user
    public UserEntity saveUser(UserEntity user) {

        return userRepository.save(user);
    }

    // List all users
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }


    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

}


// add passwordEncoder

//@Service
//public class UserService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Transactional
//    public void register(String username, String rawPassword) {
//        if (userRepository.existsByUsername(username)) {
//            throw new UserAlreadyExistException("User " + username + " already exists");
//        }
//        String encodedPassword = passwordEncoder.encode(rawPassword);
//        UserEntity newUser = new UserEntity();
//        newUser.setUsername(username);
//        newUser.setPassword(encodedPassword);
//        userRepository.save(newUser);
//    }
//
//    public UserEntity saveUser(UserEntity user) {
//        return userRepository.save(user);
//    }
//
//    public List<UserEntity> findAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public void deleteUserById(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    public boolean existsByUsername(String username) {
//        return userRepository.existsByUsername(username);
//    }
//
//    public void deleteByUsername(String username) {
//        userRepository.deleteByUsername(username);
//    }
//}