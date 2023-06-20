package org.example.http.rest;

import lombok.RequiredArgsConstructor;
import org.example.dto.CarCreateDto;
import org.example.dto.CarReadDto;
import org.example.service.CarService;
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
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarRestController {

    private final CarService carService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<CarReadDto> findAll() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public CarReadDto findById(@PathVariable("id") Integer id) {
        return carService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CarReadDto create(@RequestBody CarCreateDto carCreateDto) {
        return carService.create(carCreateDto);
    }

    @PutMapping("/{id}")
    public CarReadDto update(@PathVariable("id") Integer id,
                             @RequestBody CarCreateDto carCreateDto) {
        return carService.update(id, carCreateDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        if (!carService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
