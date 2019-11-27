package com.squaddois.centralerros.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime createdAt;
}
