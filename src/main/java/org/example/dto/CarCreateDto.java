package org.example.dto;

import lombok.Value;

@Value
public class CarCreateDto {

    String vinCode;
    String brand;
    String model;
    Integer yearIssue;
    String colour;
    Integer seatsQuantity;
    Integer garageId;
}
