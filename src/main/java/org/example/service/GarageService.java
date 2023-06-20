package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.database.repository.GarageRepository;
import org.example.dto.GarageCreateDto;
import org.example.dto.GarageReadDto;
import org.example.mapper.GarageCreateMapper;
import org.example.mapper.GarageReadMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GarageService {

    private final GarageRepository garageRepository;
    private final GarageReadMapper garageReadMapper;
    private final GarageCreateMapper garageCreateMapper;

    public List<GarageReadDto> findAll() {
        return garageRepository.findAll().stream()
                .map(garageReadMapper::map)
                .toList();
    }

    public Optional<GarageReadDto> findById(Integer id) {
        return garageRepository.findById(id)
                .map(garageReadMapper::map);
    }

    @Transactional
    public GarageReadDto create(GarageCreateDto garageCreateDto) {
        return Optional.of(garageCreateDto)
                .map(garageCreateMapper::map)
                .map(garageRepository::save)
                .map(garageReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<GarageReadDto> update(Integer id, GarageCreateDto garageCreateDto) {
        return garageRepository.findById(id)
                .map(entity -> garageCreateMapper.map(garageCreateDto, entity))
                .map(garageRepository::saveAndFlush)
                .map(garageReadMapper::map);
    }

    @Transactional
    public boolean delete(Integer id) {
        return garageRepository.findById(id)
                .map(entity -> {
                    garageRepository.delete(entity);
                    garageRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
