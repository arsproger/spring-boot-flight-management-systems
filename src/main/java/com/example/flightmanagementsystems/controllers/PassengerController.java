package com.example.flightmanagementsystems.controllers;

import com.example.flightmanagementsystems.dtos.PassengerDTO;
import com.example.flightmanagementsystems.mappers.PassengerMapper;
import com.example.flightmanagementsystems.models.Passenger;
import com.example.flightmanagementsystems.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public ResponseEntity<List<PassengerDTO>> getAllPassenger() {
        List<PassengerDTO> passengerDTOS = passengerService.getAll().stream()
                .map(PassengerMapper.INSTANCE::toDTO)
                .map(passenger -> passenger.add(linkTo(PassengerController.class)
                        .slash(passenger.getId()).withSelfRel())).toList();
        return ResponseEntity.ok(passengerDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerDTO> getPassengerById(@PathVariable Long id) {
        Passenger passenger = passengerService.getById(id);
        PassengerDTO passengerDTO = PassengerMapper.INSTANCE.toDTO(passenger)
                .add(linkTo(PassengerController.class).withSelfRel());
        return ResponseEntity.ok(passengerDTO);
    }

    @PostMapping
    public ResponseEntity<Long> createPassenger(@RequestBody PassengerDTO passengerDTO) {
        return ResponseEntity.ok(passengerService.save(PassengerMapper.INSTANCE
                .toEntity(passengerDTO)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updatePassenger(@PathVariable Long id, @RequestBody PassengerDTO passengerDTO) {
        return ResponseEntity.ok(passengerService.updateById(id, PassengerMapper.INSTANCE
                .toEntity(passengerDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletePassenger(@PathVariable Long id) {
        return new ResponseEntity<>(passengerService.deleteById(id), HttpStatus.NO_CONTENT);
    }

}
