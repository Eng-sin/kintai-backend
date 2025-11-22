package com.example.kintai_backend.service;

import com.example.kintai_backend.entity.Users;
import com.example.kintai_backend.service.dto.SignUpCommand;

public interface AuthService {
    public void regist(SignUpCommand signUpCommand);

    public boolean signIn();
}
