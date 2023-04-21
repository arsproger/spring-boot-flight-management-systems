package com.example.flightmanagementsystems.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FlightScheduleDTO extends RepresentationModel<FlightScheduleDTO> {
    private Long id;
    private String departureAirport;
    private String arrivalAirport;
    private Integer availableSeats;
}
