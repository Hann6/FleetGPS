package com.example.fleetgps.service;

import com.example.fleetgps.entity.GPSLog;
import com.example.fleetgps.repository.GPSLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GPSLogService {

    @Autowired
    private GPSLogRepository gpsLogRepository;

    public List<GPSLog> getHistory(Long vehicleId, LocalDateTime from, LocalDateTime to) {
        return gpsLogRepository.findByVehicleIdAndTimestampBetween(vehicleId, from, to);
    }

    public GPSLog getLastLocation(Long vehicleId) {
        return gpsLogRepository.findFirstByVehicleIdOrderByTimestampDesc(vehicleId);
    }

    public GPSLog saveGPSLog(GPSLog gpsLog) {
        if (gpsLog.getSpeed() > 100) {
            gpsLog.setSpeedViolation(true);  // Flagging the violation
        }
        return gpsLogRepository.save(gpsLog);
    }


}
