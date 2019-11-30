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
    private String errorCode;
    @NotEmpty
    private String title;
    @Column(length = 1000)
    private String details;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ErrorType errorType;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Environment environment;

    public Error() {
    }
}
