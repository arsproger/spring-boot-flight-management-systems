package com.example.flightmanagementsystems.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "flight_schedule")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FlightSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departureAirport;
    private String arrivalAirport;
    private Integer availableSeats;

}
