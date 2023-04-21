package com.example.flightmanagementsystems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FlightDTO extends RepresentationModel<FlightDTO> {
    private Long id;
    private Integer flightNumber;
    private Date departureTime;
    private Date arrivalTime;
}
