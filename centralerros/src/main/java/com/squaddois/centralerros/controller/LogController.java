package com.squaddois.centralerros.controller;

import com.squaddois.centralerros.dto.LogDTO;
import com.squaddois.centralerros.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {
    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findLog(@PathVariable Long id) {
        return new ResponseEntity<>(logService.findLog(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<LogDTO>> findAllLogs() {
        return new ResponseEntity<>(logService.findAllLogs(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveLog(@Valid @RequestBody LogDTO logDTO) {
        logService.saveLog(logDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateLog(@PathVariable Long id,@Valid @RequestBody LogDTO logDTO) {
        logDTO.setId(id);
        logService.saveLog(logDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id) {
        logService.deleteLog(id);
        return ResponseEntity.ok().build();
    }
}
