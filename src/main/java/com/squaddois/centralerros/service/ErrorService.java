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
        return errorRepository.findErrorByEnvironment(environment);
    }

    public void saveError(Error error) {
        errorRepository.save(error);
    }

    public void updateError(Error error) {
        errorRepository.save(error);
    }

    public Error setArchived(Long id, Boolean archived) {
        Error error = errorRepository.findById(id).get();
        error.setArchived(archived);
        errorRepository.save(error);
        return error;
    }

    public void deleteError(Long id) {
        Error error = findError(id);
        errorRepository.delete(error);
    }
}
