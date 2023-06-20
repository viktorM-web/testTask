package org.example.http.rest;

import lombok.RequiredArgsConstructor;
import org.example.dto.GarageCreateDto;
import org.example.dto.GarageReadDto;
import org.example.service.GarageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/garages")
@RequiredArgsConstructor
public class GarageRestController {

    private final GarageService garageService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<GarageReadDto> findAll() {
        return garageService.findAll();
    }

    @GetMapping("/{id}")
    public GarageReadDto findById(@PathVariable("id") Integer id) {
        return garageService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public GarageReadDto create(@RequestBody GarageCreateDto garageCreateDto) {
        return garageService.create(garageCreateDto);
    }

    @PutMapping("/{id}")
    public GarageReadDto update(@PathVariable("id") Integer id,
                                @RequestBody GarageCreateDto garageCreateDto) {
        return garageService.update(id, garageCreateDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        if (!garageService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
