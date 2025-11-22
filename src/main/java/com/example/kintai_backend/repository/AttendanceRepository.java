package com.example.kintai_backend.repository;

import com.example.kintai_backend.Enum.Status;
import com.example.kintai_backend.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
    boolean existsByUserIdAndWorkDate(Long userId, LocalDate workDate);

    Optional<Attendance> findByUserIdAndWorkDateAndStatus(Long userId, LocalDate workDate, Status status);

    Optional<Attendance> findByUserIdAndWorkDate(Long userId,LocalDate workDate);

}
