package com.example.kintai_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserAlreadyExistException extends ResponseStatusException {
    public UserAlreadyExistException(String email){
        super(HttpStatus.BAD_REQUEST,"既にそのメールアドレスは使用されています：" + email);
    }
}
