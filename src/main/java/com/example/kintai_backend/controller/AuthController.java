package com.example.kintai_backend.controller;

import com.example.kintai_backend.common.JwtUtil;
import com.example.kintai_backend.dto.request.LoginRequest;
import com.example.kintai_backend.dto.request.SignUpRequest;
import com.example.kintai_backend.dto.response.LoginResponse;
import com.example.kintai_backend.entity.Users;
import com.example.kintai_backend.repository.UsersRepository;
import com.example.kintai_backend.service.AuthService;
import com.example.kintai_backend.service.UsersService;
import com.example.kintai_backend.service.dto.SignUpCommand;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    @PostMapping("/sign-up")
    public ResponseEntity<Void> signUp(@Valid @RequestBody SignUpRequest request){

        SignUpCommand signUpCommand = new SignUpCommand(
                request.getUserName(),
                request.getPassword(),
                request.getFullName(),
                request.getEmail()
        );
        authService.regist(signUpCommand);
        return ResponseEntity.ok().build();

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        Users user = usersRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("ユーザーが存在しません"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("パスワードが正しくありません");
        }

        String token = jwtUtil.generateToken(user.getId(),user.getEmail());

        LoginResponse response = new LoginResponse(token);
        return ResponseEntity.ok(response);
    }
}
