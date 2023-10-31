package com.atmbanking.service;

import com.atmbanking.entity.User;
import com.atmbanking.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(){
        this.userRepository = new UserRepository();
    }

    public User login(String email, String password){
        return userRepository.login(email,password);
    }

}
