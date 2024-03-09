package com.suarez.apirest.presentation;
import com.suarez.apirest.domain.dtos.UserDto;
import com.suarez.apirest.domain.dtos.ResponseUserDto;
import com.suarez.apirest.domain.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/users/")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    ResponseEntity<ResponseUserDto> createUser(@Valid @RequestBody UserDto dto) {
        ResponseUserDto response = userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @RequestMapping("{id}")
    ResponseEntity<ResponseUserDto> getUserById(@PathVariable Integer id){
       ResponseUserDto response = userService.getUserById(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("{id}")
    ResponseEntity<ResponseUserDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto dto){
        ResponseUserDto response = userService.updateUser(dto, id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("all")
    ResponseEntity<List<ResponseUserDto>> getAllUsers(){
        List<ResponseUserDto> allUsers = userService.getAllUsers();
        return ResponseEntity.ok().body(allUsers);
    }
}
