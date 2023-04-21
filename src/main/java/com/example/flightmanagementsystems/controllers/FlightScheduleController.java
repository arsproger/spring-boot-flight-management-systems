package com.example.flightmanagementsystems.controllers;

import com.example.flightmanagementsystems.dtos.FlightScheduleDTO;
import com.example.flightmanagementsystems.mappers.FlightScheduleMapper;
import com.example.flightmanagementsystems.models.FlightSchedule;
import com.example.flightmanagementsystems.services.FlightScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/flight-schedules")
public class FlightScheduleController {
    private final FlightScheduleService flightScheduleService;

    @Autowired
    public FlightScheduleController(FlightScheduleService flightScheduleService) {
        this.flightScheduleService = flightScheduleService;
    }

    @GetMapping
    public ResponseEntity<List<FlightScheduleDTO>> getAllPassenger() {
        List<FlightScheduleDTO> flightScheduleDTOS = flightScheduleService.getAll().stream()
                .map(FlightScheduleMapper.INSTANCE::toDTO)
                .map(flightSchedule -> flightSchedule.add(linkTo(PassengerController.class)
                        .slash(flightSchedule.getId()).withSelfRel())).toList();
        return ResponseEntity.ok(flightScheduleDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightScheduleDTO> getFlightScheduleById(@PathVariable Long id) {
        FlightSchedule flightSchedule = flightScheduleService.getById(id);
        FlightScheduleDTO flightScheduleDTO = FlightScheduleMapper.INSTANCE.toDTO(flightSchedule)
                .add(linkTo(PassengerController.class).withSelfRel());
        return ResponseEntity.ok(flightScheduleDTO);
    }

    @PostMapping
    public ResponseEntity<Long> createFlightSchedule(@RequestBody FlightScheduleDTO flightScheduleDTO) {
        return ResponseEntity.ok(flightScheduleService.save(FlightScheduleMapper.INSTANCE
                .toEntity(flightScheduleDTO)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateFlightSchedule(@PathVariable Long id, @RequestBody FlightScheduleDTO flightScheduleDTO) {
        return ResponseEntity.ok(flightScheduleService.updateById(id, FlightScheduleMapper.INSTANCE
                .toEntity(flightScheduleDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteFlightSchedule(@PathVariable Long id) {
        return new ResponseEntity<>(flightScheduleService.deleteById(id), HttpStatus.NO_CONTENT);
    }

}
