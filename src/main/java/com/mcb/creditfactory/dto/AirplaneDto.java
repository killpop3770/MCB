package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("airplane")
public class AirplaneDto {
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;
    private Short year;
    private int amountOfFuel;
    private int seats;
}
