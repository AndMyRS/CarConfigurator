package com.andrusevich.configurator.repository;

import com.andrusevich.configurator.model.CarFeature;

import java.util.Optional;

public interface CarFeatureRepository {
    Iterable<CarFeature> findAll();

    Optional<CarFeature> findById(String id);

    CarFeature save(CarFeature carFeature);
}
