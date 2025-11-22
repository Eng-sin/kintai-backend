package com.example.kintai_backend.dto.response;

import com.example.kintai_backend.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LoginResponse {

    private String token;
}
