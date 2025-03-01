package com.rastreiofacil.rastreamento_correios.service;

import com.rastreiofacil.rastreamento_correios.model.User;
import com.rastreiofacil.rastreamento_correios.repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepositoty userRepositoty;

    public User saveUser (User user){
        return userRepositoty.save(user);
    }

    public User findByUsername(String username){
        return userRepositoty.findByUsername(username);
    }
}
