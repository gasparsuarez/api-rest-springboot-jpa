package com.suarez.apirest.infraestructure.mappers;

import com.suarez.apirest.domain.dtos.UserDto;
import com.suarez.apirest.domain.dtos.ResponseUserDto;
import com.suarez.apirest.domain.entities.User;
import com.suarez.apirest.domain.mappers.UserMapper;

public class UserMapperImpl implements UserMapper {

    @Override
    public User userDtoToUser(UserDto dto){
       if(dto == null){ return null; }

       User user = new User();

       user.setName(dto.getName());
       user.setEmail(dto.getEmail());

       return user;
    }

    @Override
    public UserDto userToUserDto(User user) {
        if(user == null){ return null; }

        UserDto dto = new UserDto();
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        return dto;
    }

    @Override
    public ResponseUserDto userToResponseDto(User user) {
        if(user == null) { return null; }

        ResponseUserDto dto = new ResponseUserDto();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        return dto;
    }
}
