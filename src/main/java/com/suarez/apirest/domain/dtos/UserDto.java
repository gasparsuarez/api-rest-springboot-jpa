package com.suarez.apirest.domain.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.*;



@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    @NotBlank(message = "Name is required")
    public String name;

    @NotBlank(message = "Email is required")
    public String email;

}
