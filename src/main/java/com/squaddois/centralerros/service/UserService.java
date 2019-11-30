package com.squaddois.centralerros.service;

import com.squaddois.centralerros.security.Encoder;
import com.squaddois.centralerros.entity.User;
import com.squaddois.centralerros.repository.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final Encoder encoder;

    @Autowired
    public UserService(UserRepository userRepository, Encoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("User not found", User.class.getName()));
    }
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        user.setPassword(encoder.passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = findUser(id);
        userRepository.delete(user);
    }
}
