package com.squaddois.centralerros.entity;

import lombok.Data;

import javax.persistence.*;
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
    @NotNull
    private Boolean archived = false;

    public Error() {
    }
}
