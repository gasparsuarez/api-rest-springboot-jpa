package com.suarez.apirest.domain.services;

import com.suarez.apirest.domain.dtos.UserDto;
import com.suarez.apirest.domain.dtos.ResponseUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

   ResponseUserDto getUserById(Integer id);

   ResponseUserDto createUser(UserDto dto);

   ResponseUserDto updateUser(UserDto dto, Long id);

   List<ResponseUserDto> getAllUsers();
}
