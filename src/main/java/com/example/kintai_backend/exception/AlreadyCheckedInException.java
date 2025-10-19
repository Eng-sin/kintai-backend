package com.example.kintai_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AlreadyCheckedInException extends ResponseStatusException {
    public AlreadyCheckedInException(Long userId){
        super(HttpStatus.CONFLICT,"既に出勤しています：" + userId);
    }
}
