package com.example.demo.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class UserDto {

        @NotNull
        private String firstName;
        @NotNull
        private String email;
        @NotNull
        private String phone;
        @NotNull
        private String password;
        @NotNull
        private String matchingPassword;
}
