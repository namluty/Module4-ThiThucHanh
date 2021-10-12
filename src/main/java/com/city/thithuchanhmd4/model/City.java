package com.city.thithuchanhmd4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCity;
    private String national;
    private double area;
    private double population;
    private double gdp;
    private String description;

}
