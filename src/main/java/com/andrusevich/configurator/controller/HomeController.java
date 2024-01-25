package com.andrusevich.configurator.controller;

import com.andrusevich.configurator.ConfigurationOrder;
import com.andrusevich.configurator.model.CarFeature;
import com.andrusevich.configurator.model.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}
