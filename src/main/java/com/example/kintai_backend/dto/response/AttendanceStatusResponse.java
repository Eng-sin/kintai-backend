package com.example.kintai_backend.dto.response;

import com.example.kintai_backend.Enum.Status;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AttendanceStatusResponse {

    private Status status;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private LocalDateTime breakStartTime;
    private LocalDateTime breakEndTime;
}
