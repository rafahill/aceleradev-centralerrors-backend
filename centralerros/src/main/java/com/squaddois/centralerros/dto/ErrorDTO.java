package com.squaddois.centralerros.dto;

import com.squaddois.centralerros.model.Environment;
import com.squaddois.centralerros.model.ErrorType;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
}
