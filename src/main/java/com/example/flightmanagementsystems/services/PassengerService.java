package com.example.flightmanagementsystems.services;

import com.example.flightmanagementsystems.models.Passenger;
import com.example.flightmanagementsystems.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<Passenger> getAll() {
        return passengerRepository.findAll();
    }

    public Passenger getById(Long id) {
        return passengerRepository.findById(id).orElse(null);
    }

    public Long save(Passenger passenger) {
        return passengerRepository.save(passenger).getId();
    }

    public Long deleteById(Long id) {
        passengerRepository.deleteById(id);
        return id;
    }

    public Long updateById(Long id, Passenger updatedPassenger) {
        Optional<Passenger> passenger = passengerRepository.findById(id);
        if (passenger.isEmpty())
            return null;

        passenger.get().setName(updatedPassenger.getName());
        passenger.get().setPassportNumber(updatedPassenger.getPassportNumber());
        passenger.get().setSeatAssignment(updatedPassenger.getSeatAssignment());

        return passengerRepository.save(passenger.get()).getId();
    }

}
