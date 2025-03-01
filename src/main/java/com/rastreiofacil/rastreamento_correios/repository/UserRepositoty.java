package com.rastreiofacil.rastreamento_correios.repository;

import com.rastreiofacil.rastreamento_correios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoty extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
