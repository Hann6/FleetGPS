package com.example.fleetgps.controller;

import com.example.fleetgps.entity.GPSLog;
import com.example.fleetgps.entity.Vehicle;
import com.example.fleetgps.service.GPSLogService;
import com.example.fleetgps.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private GPSLogService gpsLogService;

    @GetMapping("/{id}/last-location")
    public GPSLog getLastLocation(@PathVariable Long id) {
        return gpsLogService.getLastLocation(id);
    }

    @GetMapping("/{id}/history")
    public List<GPSLog> getHistory(@PathVariable Long id,
                                   @RequestParam String from,
                                   @RequestParam String to) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime fromDate = LocalDateTime.parse(from);
        LocalDateTime toDate = LocalDateTime.parse(to);

        return gpsLogService.getHistory(id, fromDate, toDate);
    }

    @PostMapping("/gps")
    public ResponseEntity<GPSLog> saveGPSLog(@Validated @RequestBody GPSLog gpsLog) {
        GPSLog savedLog = gpsLogService.saveGPSLog(gpsLog);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLog);

    }

    @PostMapping("/")
    public ResponseEntity<Vehicle> createVehicle(@Validated @RequestBody Vehicle vehicle) {
        Vehicle savedVehicle = vehicleService.createVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVehicle);
    }

}
