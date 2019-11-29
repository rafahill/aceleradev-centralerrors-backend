package com.squaddois.centralerros.mapper;

import com.squaddois.centralerros.dto.UserDTO;
import com.squaddois.centralerros.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    private UserMapper(){
        super();
    }

    public static UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setLastName(user.getLastName());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setCreatedAt(user.getCreatedAt());
        return userDTO;
    }
    public static User toUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setLastName(userDTO.getLastName());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setCreatedAt(userDTO.getCreatedAt());
        return user;
    }

    public static List<UserDTO> toListUserDTO(List<User> users) {
        return users.stream().map(UserMapper::toUserDTO).collect(Collectors.toList());
    }

    public static List<User> toListUsers(List<UserDTO> clienteDTOS) {
        return clienteDTOS.stream().map(UserMapper::toUser).collect(Collectors.toList());
    }
}
