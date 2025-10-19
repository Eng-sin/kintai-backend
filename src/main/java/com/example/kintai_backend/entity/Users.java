package com.example.kintai_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String password;

    private String fullName;

    private String email;

    private String role;

    private String employee_code;

    private Long departmentId;

    private Date hire_date;

    private String position;

    private LocalDateTime last_login_at;

    private String status;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;
}