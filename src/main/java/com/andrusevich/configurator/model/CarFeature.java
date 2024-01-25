package com.andrusevich.configurator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarFeature {

    private String id;

    private String name;

    private FeatureType featureType;

    public enum FeatureType {
        WHEELS, COLOUR, LIGHT, ENGINE
    }
}
