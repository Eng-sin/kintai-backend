package com.example.kintai_backend.service;

import com.example.kintai_backend.Enum.Status;
import com.example.kintai_backend.controller.AttendanceController;
import com.example.kintai_backend.entity.Attendance;
import com.example.kintai_backend.exception.AlreadyCheckedInException;
import com.example.kintai_backend.exception.UserNotFoundException;
import com.example.kintai_backend.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements  AttendanceService{

    private final AttendanceRepository attendanceRepository;

    private final UsersService usersService;

    private static final Logger logger = LoggerFactory.getLogger(AttendanceServiceImpl.class);

    public void checkIn(Long userId){
        if (!usersService.findUser(userId)){
            throw new UserNotFoundException(userId);
        }

        if (attendanceRepository.existsByUserIdAndWorkDate(userId,LocalDate.now())){
            throw new AlreadyCheckedInException(userId);
        }
        Attendance attendance = new Attendance();
        attendance.setUserId(userId);
        attendance.setWorkDate(LocalDate.now());
        attendance.setStatus(Status.WORKING);
        attendance.setCheckInTime(LocalDateTime.now());
        attendanceRepository.save(attendance);
        logger.info("打刻開始しました");
    }
}
