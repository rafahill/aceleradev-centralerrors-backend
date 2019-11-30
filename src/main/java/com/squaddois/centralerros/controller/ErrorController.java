package com.squaddois.centralerros.controller;

import com.squaddois.centralerros.entity.Environment;
import com.squaddois.centralerros.entity.Error;
import com.squaddois.centralerros.service.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/error")
public class ErrorController {
    private final ErrorService errorService;

    @Autowired
    public ErrorController(ErrorService errorService) {
        this.errorService = errorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findError(@PathVariable Long id) {
        return new ResponseEntity<>(errorService.findError(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Error>> findAllErrors() {
        return new ResponseEntity<>(errorService.findAllErrors(), HttpStatus.OK);
    }

    @GetMapping("/findAllByArchivedTrue")
    public ResponseEntity<List<Error>> FindByArchived() {
        return new ResponseEntity<>(errorService.findAllByArchivedTrue(), HttpStatus.OK);
    }

    @GetMapping("/findByEnvironment/{environment}")
    public ResponseEntity<List<Error>> findAllErrorsByEnvironment(@PathVariable Environment environment) {
        return new ResponseEntity<>(errorService.findErrorByEnviroment(environment), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveError(@Valid @RequestBody Error error) {
        errorService.saveError(error);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/setArchived/{archived}")
    public Error setArchived(@PathVariable Long id, @PathVariable Boolean archived) {
        return errorService.setArchived(id, archived);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteError(@PathVariable Long id) {
        errorService.deleteError(id);
        return ResponseEntity.ok().build();
    }
}
