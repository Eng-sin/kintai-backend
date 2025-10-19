package com.example.kintai_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends ResponseStatusException {
    public UserNotFoundException(Long userId){
        super(HttpStatus.BAD_REQUEST,"ユーザーが存在しません：" + userId);
    }
}
