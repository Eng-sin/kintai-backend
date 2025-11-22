package com.example.kintai_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidStatusException extends ResponseStatusException {
    public InvalidStatusException(Long userId){
        super(HttpStatus.BAD_REQUEST,"ステータスが不正です：" + userId);
    }
}
