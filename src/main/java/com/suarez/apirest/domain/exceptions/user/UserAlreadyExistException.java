package com.suarez.apirest.domain.exceptions.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserAlreadyExistException extends RuntimeException{

    private String message;
}
