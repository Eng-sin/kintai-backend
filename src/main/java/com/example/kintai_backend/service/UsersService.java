package com.example.kintai_backend.service;

public interface UsersService {
    public boolean findUser(Long userId);

    public boolean findUser(String email);
}
