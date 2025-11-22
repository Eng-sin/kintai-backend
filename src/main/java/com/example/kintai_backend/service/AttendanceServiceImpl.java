package com.example.kintai_backend.service;

import com.example.kintai_backend.Enum.Status;
import com.example.kintai_backend.controller.AttendanceController;
import com.example.kintai_backend.dto.response.AttendanceStatusResponse;
import com.example.kintai_backend.entity.Attendance;
import com.example.kintai_backend.exception.AlreadyCheckedInException;
import com.example.kintai_backend.exception.AlreadyCheckedOutException;
import com.example.kintai_backend.exception.InvalidStatusException;
import com.example.kintai_backend.exception.UserNotFoundException;
import com.example.kintai_backend.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

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

    public void checkOut(Long userId){
        if (!usersService.findUser(userId)){
            throw new UserNotFoundException(userId);
        }

        Attendance attendance = attendanceRepository.findByUserIdAndWorkDateAndStatus(userId,LocalDate.now(),Status.WORKING)
                .orElseThrow(() -> new InvalidStatusException(userId));

        attendance.setStatus(Status.LEFT);
        attendance.setCheckOutTime(LocalDateTime.now());
        attendanceRepository.save(attendance);
        logger.info("打刻終了しました");
    }

    public void breakStart(Long userId){
        if (!usersService.findUser(userId)){
            throw new UserNotFoundException(userId);
        }

        Attendance attendance = attendanceRepository.findByUserIdAndWorkDateAndStatus(userId,LocalDate.now(),Status.WORKING)
                .orElseThrow(() -> new InvalidStatusException(userId));

        attendance.setStatus(Status.BREAK);
        attendance.setBreakStartTime(LocalDateTime.now());
        attendanceRepository.save(attendance);
        logger.info("休憩開始しました");
    }

    public void breakEnd(Long userId){
        if (!usersService.findUser(userId)){
            throw new UserNotFoundException(userId);
        }

        Attendance attendance = attendanceRepository.findByUserIdAndWorkDateAndStatus(userId,LocalDate.now(),Status.BREAK)
                .orElseThrow(() -> new InvalidStatusException(userId));

        attendance.setStatus(Status.WORKING);
        attendance.setBreakEndTime(LocalDateTime.now());
        attendanceRepository.save(attendance);
        logger.info("休憩終了しました");
    }

    public AttendanceStatusResponse getCurrentStatus(Long userId){
        if (!usersService.findUser(userId)){
            throw new UserNotFoundException(userId);
        }

        Optional<Attendance> optionalAttendance = attendanceRepository.findByUserIdAndWorkDate(userId,LocalDate.now());

        if(optionalAttendance.isEmpty()){
            return new AttendanceStatusResponse(
                    Status.NOT_WORKING,
                    null,
                    null,
                    null,
                    null
            );
        }
        Attendance attendance = optionalAttendance.get();

        return new AttendanceStatusResponse(
            attendance.getStatus(),
                attendance.getCheckInTime(),
                attendance.getCheckOutTime(),
                attendance.getBreakStartTime(),
                attendance.getBreakEndTime()
        );
    }
}
