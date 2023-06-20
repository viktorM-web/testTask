package org.example.dto;

import lombok.Value;

@Value
public class GarageCreateDto {

    String city;
    String street;
    String building;
    Integer capacity;
    String name;
}
