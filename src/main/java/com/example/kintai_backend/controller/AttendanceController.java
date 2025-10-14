package com.example.kintai_backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/attendance")
public class AttendanceController {

    private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);
    /**
     * 勤務開始処理
     * @return
     */
    @PostMapping("/check-in")
    public String checkIn(){
        logger.info("打刻開始しました");
        return "打刻開始しました";
    }
}
