package com.popov.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CsvDTO {
    private String date;
    private String description;
    private double temp;
    private double pressure;
    private double humidity;
}
