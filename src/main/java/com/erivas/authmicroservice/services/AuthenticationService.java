package com.erivas.authmicroservice.services;

import com.erivas.authmicroservice.models.AuthenticationModel;
import com.erivas.authmicroservice.models.UserModel;
import com.erivas.authmicroservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // We take a user and find it by username
        UserModel userFromRepo = userRepository.findByUsername(username);

        if (userFromRepo == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        return new AuthenticationModel(userFromRepo);
    }
}
