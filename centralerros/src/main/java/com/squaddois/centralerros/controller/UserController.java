package com.squaddois.centralerros.controller;

import com.auth0.Auth0;
import com.squaddois.centralerros.dto.UserDTO;
import com.squaddois.centralerros.security.Auth0Configuration;
import com.squaddois.centralerros.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final Auth0Configuration auth0Configuration;

    @Autowired
    public UserController(UserService userService, Auth0Configuration auth0Configuration) {
        this.userService = userService;
        this.auth0Configuration = auth0Configuration;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findUser(id), HttpStatus.OK);
    }

    @GetMapping("/gamer")
    public ResponseEntity<?> getToken() {
        Auth0 token = auth0Configuration.getAuth0();
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveUser(@Valid @RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id,@Valid @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        userService.saveUser(userDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
