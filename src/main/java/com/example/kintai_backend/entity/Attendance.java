package com.example.kintai_backend.entity;

import com.example.kintai_backend.Enum.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private LocalDate workDate;

    private LocalDateTime checkInTime;

    private LocalDateTime checkOutTime;

    private LocalDateTime breakStartTime;

    private LocalDateTime breakEndTime;

    private BigDecimal work_hours;

    @Enumerated(EnumType.STRING)
    private Status status;

}
