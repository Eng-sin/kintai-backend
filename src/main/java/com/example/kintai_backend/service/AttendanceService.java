package com.example.kintai_backend.service;


import com.example.kintai_backend.dto.response.AttendanceStatusResponse;

import java.time.LocalDate;

public interface AttendanceService {

    public void checkIn(Long userId);

    public void checkOut(Long userId);

    public void breakStart(Long userId);

    public void breakEnd(Long userId);

    public AttendanceStatusResponse getCurrentStatus(Long userId);
}
