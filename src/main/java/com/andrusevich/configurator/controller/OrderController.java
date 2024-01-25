package com.andrusevich.configurator.controller;

import com.andrusevich.configurator.ConfigurationOrder;
import com.andrusevich.configurator.model.Configuration;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/orders")
@Slf4j
@SessionAttributes("configurationOrder")
public class  OrderController {

    @GetMapping("/current")
    public String orderForm(Configuration configuration) {
        log.info("Get request on /orders/current");
        return "orderForm";
    }

    @PostMapping
    public String proceedOrder(@Valid ConfigurationOrder order, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        log.info("Order received: {}", order);

        sessionStatus.setComplete();
        return "redirect:/";
    }

}
