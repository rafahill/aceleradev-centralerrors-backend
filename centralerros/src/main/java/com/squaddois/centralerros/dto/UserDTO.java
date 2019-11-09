package com.squaddois.centralerros.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String token;

}
