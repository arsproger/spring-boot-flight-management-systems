package com.example.flightmanagementsystems.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passenger")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer passportNumber;
    private String seatAssignment;


}
