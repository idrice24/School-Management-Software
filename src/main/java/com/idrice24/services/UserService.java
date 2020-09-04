package com.idrice24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.idrice24.entities.User;
import com.idrice24.repositories.RoleRepository;
import com.idrice24.repositories.UserRepository;

@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository,
	    BCryptPasswordEncoder bCryptPasswordEncoder) {
	this.userRepository = userRepository;
	this.roleRepository = roleRepository;
	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
	return userRepository.findByEmail(email);
    }

    public User saveUser(User user) {

	return userRepository.save(user);
    }

}
