package com.example.kintai_backend.service;

import com.example.kintai_backend.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService{

    private final UsersRepository repository;

    public boolean findUser(Long userId){
        return repository.existsById(userId);
    }

}
