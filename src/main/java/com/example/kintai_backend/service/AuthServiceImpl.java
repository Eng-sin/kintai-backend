package com.example.kintai_backend.service;

import com.example.kintai_backend.entity.Users;
import com.example.kintai_backend.exception.UserAlreadyExistException;
import com.example.kintai_backend.repository.UsersRepository;
import com.example.kintai_backend.service.dto.SignUpCommand;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UsersService usersService;

    private final PasswordEncoder passwordEncoder;

    private final UsersRepository usersRepository;
    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
    @Override
    public void regist(SignUpCommand signUpCommand) {
        if (usersService.findUser(signUpCommand.getEmail())){
            throw new UserAlreadyExistException(signUpCommand.getEmail());
        }
        String encodedPassword = passwordEncoder.encode(signUpCommand.getPassword());
        System.out.println(encodedPassword);

        Users user = new Users();
        user.setUserName(signUpCommand.getUserName());
        user.setPassword(encodedPassword);
        user.setFullName(signUpCommand.getFullName());
        user.setEmail(signUpCommand.getEmail());
        usersRepository.save(user);
        logger.info("ユーザー登録しました");
    }


    @Override
    public boolean signIn() {
        return true;
    }
}
