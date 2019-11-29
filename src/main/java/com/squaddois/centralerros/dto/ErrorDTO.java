package com.squaddois.centralerros.dto;

import com.squaddois.centralerros.entity.Environment;
import com.squaddois.centralerros.entity.ErrorType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorDTO {
    private Long id;
    private String hostname;
    private String title;
    private String details;
    private ErrorType errorType;
    private Environment environment;
    private LocalDateTime createdAt;
    private Boolean archived;
}
