package com.erivas.authmicroservice.utilities;

import com.erivas.authmicroservice.dtos.UserDto;
import com.erivas.authmicroservice.models.UserModel;
import com.erivas.authmicroservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    private @Autowired BCryptPasswordEncoder encoder;
    private @Autowired UserRepository repository;

    public Boolean validateEmail(UserDto userFromJson) {

        UserModel userFromModel = repository.findByEmail(userFromJson.getEmail());

        if (userFromModel != null) {
            // The email is used
            return true;
        } else {
            // The email is not used
            return false;
        }
    }

    public Boolean validatePasswords(UserDto userFromJson) {

        UserModel userFromModel = repository.findByEmail(userFromJson.getEmail());

        if (userFromModel != null) {
            // Returns true if passwords are the same
            return encoder.matches(userFromJson.getPassword(), userFromModel.getPassword());
        } else {
            return false;
        }
    }
}
