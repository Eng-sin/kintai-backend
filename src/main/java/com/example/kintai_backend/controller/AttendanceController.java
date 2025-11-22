package com.example.kintai_backend.controller;

import com.example.kintai_backend.dto.request.*;
import com.example.kintai_backend.dto.response.AttendanceStatusResponse;
import com.example.kintai_backend.service.AttendanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;
    /**
     * 勤務開始処理
     * @return
     */
    @PostMapping("/check-in")
    public ResponseEntity<Void> checkIn(Authentication auth){
        Long userId = (Long)auth.getPrincipal();
        attendanceService.checkIn(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/check-out")
    public ResponseEntity<Void> checkOut(Authentication auth){
        Long userId = (Long)auth.getPrincipal();
        attendanceService.checkOut(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/break/start")
    public ResponseEntity<Void> breakStart(Authentication auth){
        Long userId = (Long)auth.getPrincipal();
        attendanceService.breakStart(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/break/end")
    public ResponseEntity<Void> breakEnd(Authentication auth){
        Long userId = (Long)auth.getPrincipal();
        attendanceService.breakEnd(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/status")
    public ResponseEntity<AttendanceStatusResponse> getCurrentStatus(Authentication auth){
        Long userId = (Long)auth.getPrincipal();
        AttendanceStatusResponse response =  attendanceService.getCurrentStatus(userId);
        return ResponseEntity.ok(response);

    }
}
