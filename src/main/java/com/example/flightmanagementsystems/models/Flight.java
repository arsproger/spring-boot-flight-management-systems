package com.example.flightmanagementsystems.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "flight")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer flightNumber;
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalTime;

}
