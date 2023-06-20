package org.example.mapper;

import lombok.RequiredArgsConstructor;
import org.example.database.entity.Car;
import org.example.database.entity.Garage;
import org.example.database.repository.GarageRepository;
import org.example.dto.CarCreateDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CarCreateMapper implements Mapper<CarCreateDto, Car> {

    private final GarageRepository garageRepository;

    @Override
    public Car map(CarCreateDto object) {
        Car car = new Car();
        copy(object, car);
        return car;
    }

    @Override
    public Car map(CarCreateDto fromObject, Car toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    private Garage getGarage(Integer garageId) {
        return Optional.ofNullable(garageId)
                .flatMap(garageRepository::findById)
                .orElse(null);
    }

    private void copy(CarCreateDto object, Car car) {
        car.setVinCode(object.getVinCode());
        car.setBrand(object.getBrand());
        car.setModel(object.getModel());
        car.setYearIssue(object.getYearIssue());
        car.setColour(object.getColour());
        car.setSeatsQuantity(object.getSeatsQuantity());
        car.setGarage(getGarage(object.getGarageId()));
    }
}
