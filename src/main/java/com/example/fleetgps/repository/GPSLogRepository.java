package com.example.fleetgps.repository;

import com.example.fleetgps.entity.GPSLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface GPSLogRepository extends JpaRepository<GPSLog, Long> {
    List<GPSLog> findByVehicleIdAndTimestampBetween(Long vehicleId, LocalDateTime from, LocalDateTime to);
    GPSLog findFirstByVehicleIdOrderByTimestampDesc(Long vehicleId);
    void deleteAllByTimestampBefore(LocalDateTime cutoffDate);
}
