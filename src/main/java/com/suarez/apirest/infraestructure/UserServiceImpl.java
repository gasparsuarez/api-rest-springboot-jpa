package com.suarez.apirest.infraestructure;

import com.suarez.apirest.domain.dtos.UserDto;
import com.suarez.apirest.domain.dtos.ResponseUserDto;
import com.suarez.apirest.domain.exceptions.user.UserAlreadyExistException;
import com.suarez.apirest.domain.exceptions.user.UserNotFoundException;
import com.suarez.apirest.domain.entities.User;
import com.suarez.apirest.domain.mappers.UserMapper;
import com.suarez.apirest.domain.repositories.UserRepository;
import com.suarez.apirest.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseUserDto getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) throw new UserNotFoundException("El usuario no existe");

        return userMapper.userToResponseDto(user.get());
    }


    @Override
    public ResponseUserDto createUser(UserDto dto) {

        boolean existUser = userRepository.existsByEmail(dto.getEmail());

        if(existUser) throw new UserAlreadyExistException("El usuario ya existe");

        User user = userMapper.userDtoToUser(dto);

        userRepository.save(user);

        return userMapper.userToResponseDto(user);
    }

    @Override
    public ResponseUserDto updateUser(UserDto dto, Long id) {

        User user = userRepository.findById(id);

        if(user == null) { throw new UserNotFoundException("El usuario no existe"); }

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        userRepository.save(user);

        return userMapper.userToResponseDto(user);
    }

    @Override
    public List<ResponseUserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(userMapper::userToResponseDto)
                .toList();
    }
}
