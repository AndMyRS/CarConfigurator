package com.andrusevich.configurator.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Configuration {

    private Long id;

    private String name;

    private List<CarFeature> features;
}
