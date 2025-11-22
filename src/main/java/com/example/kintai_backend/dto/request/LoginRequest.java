package com.example.kintai_backend.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequest {

    @NotNull(message = "メールアドレスは必須です")
    private String email;

    @NotNull(message = "パスワードは必須です")
    private String password;

    @NotNull(message = "ユーザー名は必須です")
    private String userName;

    @NotNull(message = "フルネームは必須です")
    private String fullName;

}
