package com.suarez.apirest.domain.mappers;

import com.suarez.apirest.domain.dtos.UserDto;
import com.suarez.apirest.domain.dtos.ResponseUserDto;
import com.suarez.apirest.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "email", source = "dto.email")
    User userDtoToUser(UserDto dto);

    UserDto userToUserDto(User user);

    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "email", source = "user.email")
    ResponseUserDto userToResponseDto(User user);
}
