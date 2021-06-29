package com.erivas.authmicroservice.controllers;

import com.erivas.authmicroservice.dtos.UserDto;
import com.erivas.authmicroservice.services.UserService;
import com.erivas.authmicroservice.utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.REGISTER_URL)
public class RegisterController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody UserDto newUserDto) {

        // Send object to service
        boolean success = service.registerUser(newUserDto);

        if (success) {
            return new ResponseEntity<>("You have been successfully registered. Please activate your account.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("The email is taken", HttpStatus.BAD_REQUEST);
        }
    }
}
