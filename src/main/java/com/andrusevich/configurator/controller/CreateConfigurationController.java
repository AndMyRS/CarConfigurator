package com.andrusevich.configurator.controller;

import com.andrusevich.configurator.ConfigurationOrder;
import com.andrusevich.configurator.model.CarFeature;
import com.andrusevich.configurator.model.Configuration;
import com.andrusevich.configurator.repository.CarFeatureRepository;
import com.andrusevich.configurator.repository.JdbcCarFeatureRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("home/create")
@SessionAttributes("configurationOrder")
public class CreateConfigurationController {

    private final CarFeatureRepository featureRepository;

    @ModelAttribute
    public void addFeaturesToModel(Model model) {
        /*List<CarFeature> carFeatures = Arrays.asList(
                new CarFeature("CDPB", "Colour Aquamarine", CarFeature.FeatureType.COLOUR),
                new CarFeature("LM12", "Colour Scarlet Cherry", CarFeature.FeatureType.COLOUR),
                new CarFeature("3FM4", "Colour Dark Olive", CarFeature.FeatureType.COLOUR),

                new CarFeature("W5L", "Evo Black Line", CarFeature.FeatureType.WHEELS),
                new CarFeature("HJNM", "R17 POWCAN", CarFeature.FeatureType.WHEELS),
                new CarFeature("XZ94", "Cast wheels R18", CarFeature.FeatureType.WHEELS),

                new CarFeature("LMLED", "Matrix LED", CarFeature.FeatureType.LIGHT),
                new CarFeature("QA9P", "HID Xenon Laser", CarFeature.FeatureType.LIGHT),
                new CarFeature("KODA", "Adaptive LED", CarFeature.FeatureType.LIGHT),

                new CarFeature("EBT3", "BiTurbo 3.6L", CarFeature.FeatureType.ENGINE),
                new CarFeature("OP9L", "TwinTurbo V8 with double clutch", CarFeature.FeatureType.ENGINE),
                new CarFeature("JV65", "V12 6.5L", CarFeature.FeatureType.ENGINE)*/

        Iterable<CarFeature> carFeatures = featureRepository.findAll();

        /*CarFeature.FeatureType[] types = CarFeature.FeatureType.values();
        for (CarFeature.FeatureType type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(carFeatures, type));
        }*/

    }

    @ModelAttribute(name = "configurationOrder")
    public ConfigurationOrder order() {
        return new ConfigurationOrder();
    }

    @ModelAttribute(name = "configuration")
    public Configuration configuration() {
        return new Configuration();
    }

    @GetMapping
    public String showCreateForm() {
        return "create";
    }
    private Iterable<CarFeature> filterByType(List<CarFeature> carFeatures, CarFeature.FeatureType type) {
        return carFeatures.stream()
                .filter(x -> x.getFeatureType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String proceedConfiguration(@Valid Configuration configuration, Errors errors,
                                       @ModelAttribute ConfigurationOrder configurationOrder) {
        if (errors.hasErrors()) {
            return "create";
        }

        configurationOrder.addConfiguration(configuration);

        log.info("Proceeding configuration: {}", configuration);
         return "redirect:/orders/current";
    }

}
