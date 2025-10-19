package com.example.kintai_backend.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CheckInRequest {

    @NotNull(message = "ユーザーIDは必須です")
    private Long userId;
}
