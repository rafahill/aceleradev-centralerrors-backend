package com.squaddois.centralerros.service;

import com.squaddois.centralerros.repository.ErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorService {

    private final ErrorRepository errorRepository;

    @Autowired
    public ErrorService(ErrorRepository errorRepository) {
        this.errorRepository = errorRepository;
    }
}
