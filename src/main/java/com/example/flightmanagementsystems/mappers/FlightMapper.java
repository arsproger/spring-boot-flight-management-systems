package com.example.flightmanagementsystems.mappers;

import com.example.flightmanagementsystems.dtos.FlightDTO;
import com.example.flightmanagementsystems.models.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "flightNumber", target = "flightNumber")
    @Mapping(source = "departureTime", target = "departureTime")
    @Mapping(source = "arrivalTime", target = "arrivalTime")
    FlightDTO toDTO(Flight flight);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "flightNumber", target = "flightNumber")
    @Mapping(source = "departureTime", target = "departureTime")
    @Mapping(source = "arrivalTime", target = "arrivalTime")
    Flight toEntity(FlightDTO flightDTO);
}
