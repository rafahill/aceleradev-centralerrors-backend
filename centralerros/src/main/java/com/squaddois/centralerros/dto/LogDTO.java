package com.squaddois.centralerros.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class LogDTO {

    private long id;
    private String ip;
    private LocalDateTime createdAt;
    private String description;
}
