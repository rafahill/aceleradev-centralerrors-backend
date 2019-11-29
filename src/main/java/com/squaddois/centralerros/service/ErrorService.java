package com.squaddois.centralerros.service;

import com.squaddois.centralerros.entity.Environment;
import com.squaddois.centralerros.entity.Error;
import com.squaddois.centralerros.repository.ErrorRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrorService {

    private final ErrorRepository errorRepository;

    @Autowired
    public ErrorService(ErrorRepository errorRepository) {
        this.errorRepository = errorRepository;
    }

    public Error findError(Long id) {
        return errorRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Error not found", Error.class.getName()));
    }

    public List<Error> findAllErrors() {
        return errorRepository.findAll();
    }

    public List<Error> findErrorByEnviroment(Environment environment) {
        return errorRepository.findErrorsByEnvironment(environment);
    }
    public List<Error> findErrorsByArchived(Boolean archived) {
        return errorRepository.findErrorsByArchived(archived);
}

    public List<Error> findErrorsByEnvironmentAndArchived(Environment environment, Boolean archived) {
        return errorRepository.findErrorsByEnvironmentAndArchived(environment, archived);
    }

    public void saveError(Error error) {
        errorRepository.save(error);
    }

    public void updateError(Error error) {
        errorRepository.save(error);
    }

    public void deleteError(Long id) {
        Error error = findError(id);
        errorRepository.delete(error);
    }
}
