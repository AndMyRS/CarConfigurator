package com.andrusevich.configurator.converter;

import com.andrusevich.configurator.model.CarFeature;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CarFeatureByIdConverter implements Converter<String, CarFeature> {

    private Map<String, CarFeature> carFeatureMap = new HashMap<>();

    public CarFeatureByIdConverter() {
        carFeatureMap.put("CDPB", new CarFeature("CDPB", "Colour DeepBlue", CarFeature.FeatureType.COLOUR));
        carFeatureMap.put("W5L", new CarFeature("W5L", "5 locks wheels", CarFeature.FeatureType.WHEELS));
        carFeatureMap.put("LMLED", new CarFeature("LMLED", "Matrix LED", CarFeature.FeatureType.LIGHT));
        carFeatureMap.put("EBT3", new CarFeature("EBT3", "BiTurbo 3.6L", CarFeature.FeatureType.ENGINE));
    }

    @Override
    public CarFeature convert(String id) {
        return carFeatureMap.get(id);
    }
}
