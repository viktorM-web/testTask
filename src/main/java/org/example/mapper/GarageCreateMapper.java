package org.example.mapper;

import lombok.RequiredArgsConstructor;
import org.example.database.entity.Garage;
import org.example.dto.GarageCreateDto;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GarageCreateMapper implements Mapper<GarageCreateDto, Garage> {

    @Override
    public Garage map(GarageCreateDto object) {
        Garage garage = new Garage();
        copy(object, garage);
        return garage;
    }

    @Override
    public Garage map(GarageCreateDto fromObject, Garage toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    private void copy(GarageCreateDto object, Garage garage) {
        garage.setCity(object.getCity());
        garage.setStreet(object.getStreet());
        garage.setBuilding(object.getBuilding());
        garage.setCapacity(object.getCapacity());
        garage.setName(object.getName());
    }
}
