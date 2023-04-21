package com.example.flightmanagementsystems.services;

import com.example.flightmanagementsystems.models.FlightSchedule;
import com.example.flightmanagementsystems.repositories.FlightScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightScheduleService {
    private final FlightScheduleRepository flightScheduleRepository;

    @Autowired
    public FlightScheduleService(FlightScheduleRepository flightScheduleRepository) {
        this.flightScheduleRepository = flightScheduleRepository;
    }

    public List<FlightSchedule> getAll() {
        return flightScheduleRepository.findAll();
    }

    public FlightSchedule getById(Long id) {
        return flightScheduleRepository.findById(id).orElse(null);
    }

    public Long save(FlightSchedule flightSchedule) {
        return flightScheduleRepository.save(flightSchedule).getId();
    }

    public Long deleteById(Long id) {
        flightScheduleRepository.deleteById(id);
        return id;
    }

    public Long updateById(Long id, FlightSchedule updatedFlightSchedule) {
        Optional<FlightSchedule> flightSchedule = flightScheduleRepository.findById(id);
        if (flightSchedule.isEmpty())
            return null;

        flightSchedule.get().setDepartureAirport(updatedFlightSchedule.getDepartureAirport());
        flightSchedule.get().setArrivalAirport(updatedFlightSchedule.getArrivalAirport());
        flightSchedule.get().setAvailableSeats(updatedFlightSchedule.getAvailableSeats());

        return flightScheduleRepository.save(flightSchedule.get()).getId();
    }

}
