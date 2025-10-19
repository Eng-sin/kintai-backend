package com.example.kintai_backend.controller;

import com.example.kintai_backend.dto.request.CheckInRequest;
import com.example.kintai_backend.service.AttendanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> checkIn(@Valid @RequestBody CheckInRequest request){
        Long userId = request.getUserId();
        attendanceService.checkIn(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/check-out")
    public String checkOut(){
        return "打刻終了しました";
    }
}
