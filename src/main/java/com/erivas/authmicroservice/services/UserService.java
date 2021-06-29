package com.erivas.authmicroservice.services;

import com.erivas.authmicroservice.dtos.UserDto;
import com.erivas.authmicroservice.mappers.UserMapper;
import com.erivas.authmicroservice.models.UserModel;
import com.erivas.authmicroservice.repositories.UserRepository;
import com.erivas.authmicroservice.utilities.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired private BCryptPasswordEncoder encoder;
    @Autowired private UserRepository repository;
    @Autowired private UserMapper userMapper;
    @Autowired private Validator validator;

    public boolean registerUser(UserDto userDto) {

        boolean emailTaken = validator.validateEmail(userDto);

        if (!emailTaken) {
            // Convert to model
            UserModel userModel = userMapper.toEntity(userDto);

            // Define basic attributes
            userModel.setActivated(false);
            userModel.setDeleted(false);

            // Define password
            userModel.setPassword(encoder.encode(userModel.getPassword()));

            // Save in database
            repository.save(userModel);

            return true;

        } else {
            return false;
        }


    }

    public boolean loginUser(UserDto userDto) {
        
        // TODO return token
        return validator.validatePasswords(userDto);

    }
}
