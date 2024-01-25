package com.andrusevich.configurator;

import com.andrusevich.configurator.model.Configuration;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationOrder {

    private long id;

    @NotNull(message = "First name is required")
    private String clientFirstName;

    @NotNull(message = "Last name is required")
    private String clientLastName;

    @NotBlank(message = "Delivery city is required")
    private String deliveryCity;

    private LocalDate deliveryDate;

    private boolean paymentByCard;

    private List<Configuration> configurationsToChoose = new ArrayList<>();

    public void addConfiguration(Configuration configuration) {
        this.configurationsToChoose.add(configuration);
    }

}
