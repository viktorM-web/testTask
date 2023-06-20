package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.database.repository.CarRepository;
import org.example.dto.CarCreateDto;
import org.example.dto.CarReadDto;
import org.example.mapper.CarCreateMapper;
import org.example.mapper.CarReadMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CarService {

    private final CarRepository carRepository;
    private final CarReadMapper carReadMapper;
    private final CarCreateMapper carCreateMapper;

    public List<CarReadDto> findAll() {
        return carRepository.findAll().stream()
                .map(carReadMapper::map)
                .toList();
    }

    public Optional<CarReadDto> findById(Integer id) {
        return carRepository.findById(id)
                .map(carReadMapper::map);
    }

    @Transactional
    public CarReadDto create(CarCreateDto carCreateDto) {
        return Optional.of(carCreateDto)
                .map(carCreateMapper::map)
                .map(carRepository::save)
                .map(carReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<CarReadDto> update(Integer id, CarCreateDto carCreateDto) {
        return carRepository.findById(id)
                .map(entity -> carCreateMapper.map(carCreateDto, entity))
                .map(carRepository::saveAndFlush)
                .map(carReadMapper::map);
    }

    @Transactional
    public boolean delete(Integer id) {
        return carRepository.findById(id)
                .map(entity -> {
                    carRepository.delete(entity);
                    carRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
