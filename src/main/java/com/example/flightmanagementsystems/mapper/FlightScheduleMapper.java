package com.example.flightmanagementsystems.mapper;

import com.example.flightmanagementsystems.dto.FlightScheduleDTO;
import com.example.flightmanagementsystems.models.FlightSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface FlightScheduleMapper {
    FlightScheduleMapper INSTANCE = Mappers.getMapper(FlightScheduleMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "departureAirport", target = "departureAirport")
    @Mapping(source = "arrivalAirport", target = "arrivalAirport")
    @Mapping(source = "availableSeats", target = "availableSeats")
    FlightScheduleDTO toDTO(FlightSchedule flightSchedule);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "departureAirport", target = "departureAirport")
    @Mapping(source = "arrivalAirport", target = "arrivalAirport")
    @Mapping(source = "availableSeats", target = "availableSeats")
    FlightSchedule toEntity(FlightScheduleDTO flightScheduleDTO);
}
