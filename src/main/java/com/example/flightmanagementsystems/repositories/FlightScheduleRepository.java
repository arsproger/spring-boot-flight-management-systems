package com.example.flightmanagementsystems.repositories;

import com.example.flightmanagementsystems.models.FlightSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Long> {

}
