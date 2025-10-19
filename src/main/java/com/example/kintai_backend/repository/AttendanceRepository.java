package com.example.kintai_backend.repository;

import com.example.kintai_backend.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
    boolean existsByUserIdAndWorkDate(Long userId, LocalDate workDate);
}
