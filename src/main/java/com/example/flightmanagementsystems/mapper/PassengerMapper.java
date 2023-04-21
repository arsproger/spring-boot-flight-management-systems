package com.example.flightmanagementsystems.mapper;

import com.example.flightmanagementsystems.dto.PassengerDTO;
import com.example.flightmanagementsystems.models.Passenger;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface PassengerMapper {
    PassengerMapper INSTANCE = Mappers.getMapper(PassengerMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "passportNumber", target = "passportNumber")
    @Mapping(source = "seatAssignment", target = "seatAssignment")
    PassengerDTO toDTO(Passenger passenger);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "passportNumber", target = "passportNumber")
    @Mapping(source = "seatAssignment", target = "seatAssignment")
    Passenger toEntity(PassengerDTO passengerDTO);
}
