package com.squaddois.centralerros.service;

import com.squaddois.centralerros.config.Encoder;
import com.squaddois.centralerros.dto.UserDTO;
import com.squaddois.centralerros.mapper.UserMapper;
import com.squaddois.centralerros.model.User;
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

    public UserDTO findUser(Long id) {
        return UserMapper.toUserDTO(userRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("User not found", User.class.getName())));
    }

    public List<UserDTO> findAllUsers() {
        return UserMapper.toListUserDTO(userRepository.findAll());
    }

    public void saveUser(UserDTO userDTO) {
        userDTO.setPassword(encoder.passwordEncoder().encode(userDTO.getPassword()));
        userRepository.save(UserMapper.toUser(userDTO));
    }

    public void updateUser(UserDTO userDTO) {
        userRepository.save(UserMapper.toUser(userDTO));
    }

    public void deleteUser(Long id) {
        UserDTO userDTO = findUser(id);
        userRepository.delete(UserMapper.toUser(userDTO));
    }
}
