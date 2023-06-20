package org.example.dto;

import lombok.Value;

@Value
public class GarageReadDto {

    Integer id;
    String city;
    String street;
    String building;
    Integer capacity;
    String name;
}
