package com.example.frituurfrieda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

@Controller   // Spring maakt van de class indexController() een object (een Spring bean)
@RequestMapping("/")
class IndexController {
    private final AtomicInteger aantalBezoeken = new AtomicInteger();
    @GetMapping
    public ModelAndView index_() {
        var morgenOfMiddag = LocalTime.now().getHour() < 12 ? "morgen" : "middag";
        var modelAndView = new ModelAndView("index","moment", morgenOfMiddag);
        modelAndView.addObject("aantalBezoeken", aantalBezoeken.incrementAndGet());
        return modelAndView;
    }
}