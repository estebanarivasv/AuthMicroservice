package com.erivas.authmicroservice.controllers;

import com.erivas.authmicroservice.dtos.UserDto;
import com.erivas.authmicroservice.services.UserService;
import com.erivas.authmicroservice.utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.LOGIN_URL)
public class LoginController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody UserDto newUserDto) {
        // Send object to service
        boolean success = service.loginUser(newUserDto);

        if (success) {
            return new ResponseEntity<>("Successful login", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Wrong credentials. Try again.", HttpStatus.BAD_REQUEST);
        }
    }


}