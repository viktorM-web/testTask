package org.example.mapper;

import lombok.RequiredArgsConstructor;
import org.example.database.entity.Car;
import org.example.dto.CarReadDto;
import org.example.dto.GarageReadDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CarReadMapper implements Mapper<Car, CarReadDto> {

    private final GarageReadMapper garageReadMapper;

    @Override
    public CarReadDto map(Car object) {
        GarageReadDto garage = Optional.ofNullable((object.getGarage()))
                .map(garageReadMapper::map)
                .orElse(null);
        return new CarReadDto(
                object.getId(),
                object.getVinCode(),
                object.getBrand(),
                object.getModel(),
                object.getYearIssue(),
                object.getColour(),
                object.getSeatsQuantity(),
                garage
        );
    }
}
