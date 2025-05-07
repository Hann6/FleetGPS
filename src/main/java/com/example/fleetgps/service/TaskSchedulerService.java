package com.example.fleetgps.service;

import com.example.fleetgps.repository.GPSLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskSchedulerService {

    @Autowired
    private GPSLogRepository gpsLogRepository;

    @Scheduled(cron = "0 0 0 * * ?")  // Runs every midnight
    public void cleanOldLogs() {
        LocalDateTime cutoffDate = LocalDateTime.now().minusDays(30);
        gpsLogRepository.deleteAllByTimestampBefore(cutoffDate);  // Deleting logs older than 30 days
    }
}
