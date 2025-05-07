package com.example.fleetgps.service;

import com.example.fleetgps.entity.Vehicle;
import com.example.fleetgps.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;  // Assuming you have a VehicleRepository for DB access

    public Vehicle createVehicle(Vehicle vehicle) {
        // Save the vehicle to the database
        return vehicleRepository.save(vehicle);
    }
}
