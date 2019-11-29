package com.squaddois.centralerros.controller;

import com.squaddois.centralerros.dto.ErrorDTO;
import com.squaddois.centralerros.dto.ErrorReducedDTO;
import com.squaddois.centralerros.entity.Environment;
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
    public ResponseEntity<List<ErrorReducedDTO>> findAllErrors() {
        return new ResponseEntity<>(errorService.findAllErrors(), HttpStatus.OK);
    }

    @GetMapping("/findAllByEnvironment/{environment}")
    public ResponseEntity<List<ErrorReducedDTO>> findAllErrorsByEnvironment(@PathVariable Environment environment) {
        return new ResponseEntity<>(errorService.findErrorsByEnviroment(environment), HttpStatus.OK);
    }

    @GetMapping("/findAllByArchived/{archived}")
    public ResponseEntity<List<ErrorReducedDTO>> findAllErrorsByArchived(@PathVariable Boolean archived) {
        return new ResponseEntity<>(errorService.findErrorsByArchived(archived), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findErrorsBy", params = {"environment", "archived"})
    public ResponseEntity<List<ErrorReducedDTO>> findErrorsBy(@RequestParam Environment environment, @RequestParam Boolean archived) {
        return new ResponseEntity<>(errorService.findErrorsByEnvironmentAndArchived(environment, archived), HttpStatus.OK);
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
    public ResponseEntity<Void> deleteError(@PathVariable Long id) {
        errorService.deleteError(id);
        return ResponseEntity.ok().build();
    }
}
