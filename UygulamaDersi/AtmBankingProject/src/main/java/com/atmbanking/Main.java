package com.atmbanking;

import com.atmbanking.entity.User;
import com.atmbanking.repository.UserRepository;

public class Main {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();

        User user = userRepository.login("mehmet@gmail.com","12345");
        System.out.println("Hoşgeldniz :"+user.getEmail());
    }
}