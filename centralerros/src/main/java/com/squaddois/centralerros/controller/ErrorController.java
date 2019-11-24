package com.squaddois.centralerros.controller;

import com.squaddois.centralerros.dto.ErrorDTO;
import com.squaddois.centralerros.model.Environment;
import com.squaddois.centralerros.service.ErrorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public ResponseEntity<List<ErrorDTO>> findAllErrors() {
        return new ResponseEntity<>(errorService.findAllErrors(), HttpStatus.OK);
    }
    @GetMapping("/findByEnvironment/{environment}")
    public ResponseEntity<List<ErrorDTO>> findAllErrorsByEnvironment(@PathVariable Environment environment) {
        return new ResponseEntity<>(errorService.findErrorByEnviroment(environment), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveError(@Valid @RequestBody ErrorDTO errorDTO) {
        errorService.saveError(errorDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateError(@PathVariable Long id,@Valid @RequestBody ErrorDTO errorDTO) {
        errorDTO.setId(id);
        errorService.saveError(errorDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        errorService.deleteError(id);
        return ResponseEntity.ok().build();
    }
}
