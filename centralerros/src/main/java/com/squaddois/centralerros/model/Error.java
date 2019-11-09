package com.squaddois.centralerros.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
public class Error {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String hostname;
    @NotEmpty
    private String title;
    private String details;
    @NotNull
    private ErrorType errorType;
    @NotNull
    private Environment environment;

    @CreatedDate
    private LocalDateTime createdAt;

    public Error() {
    }
}
