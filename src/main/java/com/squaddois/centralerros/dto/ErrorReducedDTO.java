package com.squaddois.centralerros.dto;

import com.squaddois.centralerros.entity.ErrorType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorReducedDTO {
    private Long id;
    private String title;
    private ErrorType errorType;
    private LocalDateTime createdAt;
}
