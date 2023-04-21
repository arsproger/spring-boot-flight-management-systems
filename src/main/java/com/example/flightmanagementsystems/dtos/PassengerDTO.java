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
public class PassengerDTO extends RepresentationModel<PassengerDTO> {
    private Long id;
    private String name;
    private Integer passportNumber;
    private String seatAssignment;
}
