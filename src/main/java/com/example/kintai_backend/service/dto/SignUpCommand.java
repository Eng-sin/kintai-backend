package com.example.kintai_backend.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpCommand {

    private final String userName;
    private final String password;
    private final String fullName;
    private final String email;
}
