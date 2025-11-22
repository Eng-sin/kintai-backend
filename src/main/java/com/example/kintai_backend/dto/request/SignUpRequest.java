package com.example.kintai_backend.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignUpRequest {

    @NotNull(message = "ユーザー名は必須です")
    private String userName;

    @NotNull(message = "メールアドレスは必須です")
    private String email;

    @NotNull(message = "パスワードは必須です")
    private String password;

    @NotNull(message = "名前は必須です")
    private String fullName;
}
