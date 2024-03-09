package com.suarez.apirest.domain.repositories;

import com.suarez.apirest.domain.dtos.UserDto;
import com.suarez.apirest.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    User findById(Long id);
}


