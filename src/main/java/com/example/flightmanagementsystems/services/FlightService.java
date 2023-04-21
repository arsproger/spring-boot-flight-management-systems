package com.example.flightmanagementsystems.services;

import com.example.flightmanagementsystems.models.Flight;
import com.example.flightmanagementsystems.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    public Flight getById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Long save(Flight flight) {
        return flightRepository.save(flight).getId();
    }

    public Long deleteById(Long id) {
        flightRepository.deleteById(id);
        return id;
    }

    public Long updateById(Long id, Flight updatedFlight) {
        Optional<Flight> flight = flightRepository.findById(id);
        if(flight.isEmpty())
            return null;

        flight.get().setFlightNumber(updatedFlight.getFlightNumber());
        flight.get().setDepartureTime(updatedFlight.getDepartureTime());
        flight.get().setArrivalTime(updatedFlight.getArrivalTime());

        return flightRepository.save(flight.get()).getId();
    }

}
