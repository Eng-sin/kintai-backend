package com.example.kintai_backend.exception;

import com.example.kintai_backend.Enum.Status;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AlreadyCheckedOutException extends ResponseStatusException {
    public AlreadyCheckedOutException(Long userId){
        super(HttpStatus.CONFLICT,"既に退勤しています：" + userId);
    }
}
