package com.squaddois.centralerros.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Error extends BaseEntity {
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

    public Error() {
    }
}
