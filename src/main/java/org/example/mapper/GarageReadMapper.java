package org.example.mapper;

import lombok.RequiredArgsConstructor;
import org.example.database.entity.Garage;
import org.example.dto.GarageReadDto;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GarageReadMapper implements Mapper<Garage, GarageReadDto> {

    @Override
    public GarageReadDto map(Garage object) {
        return new GarageReadDto(
                object.getId(),
                object.getCity(),
                object.getStreet(),
                object.getBuilding(),
                object.getCapacity(),
                object.getName()
        );
    }
}
