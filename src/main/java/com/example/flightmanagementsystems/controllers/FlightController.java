package com.example.flightmanagementsystems.controllers;

import com.example.flightmanagementsystems.dto.FlightDTO;
import com.example.flightmanagementsystems.mapper.FlightMapper;
import com.example.flightmanagementsystems.models.Flight;
import com.example.flightmanagementsystems.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public ResponseEntity<List<FlightDTO>> getAllPassenger() {
        List<FlightDTO> flightDTOS = flightService.getAll().stream()
                .map(FlightMapper.INSTANCE::toDTO)
                .map(passenger -> passenger.add(linkTo(PassengerController.class)
                        .slash(passenger.getId()).withSelfRel())).toList();
        return ResponseEntity.ok(flightDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable Long id) {
        Flight flight = flightService.getById(id);
        FlightDTO flightDTO = FlightMapper.INSTANCE.toDTO(flight)
                .add(linkTo(PassengerController.class).withSelfRel());
        return ResponseEntity.ok(flightDTO);
    }

    @PostMapping
    public ResponseEntity<Long> createFlight(@RequestBody FlightDTO flightDTO) {
        return ResponseEntity.ok(flightService.save(FlightMapper.INSTANCE
                .toEntity(flightDTO)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateFlight(@PathVariable Long id, @RequestBody FlightDTO flightDTO) {
        return ResponseEntity.ok(flightService.updateById(id, FlightMapper.INSTANCE
                .toEntity(flightDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteFlight(@PathVariable Long id) {
        return new ResponseEntity<>(flightService.deleteById(id), HttpStatus.NO_CONTENT);
    }

}
