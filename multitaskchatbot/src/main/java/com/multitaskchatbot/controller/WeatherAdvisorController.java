package com.multitaskchatbot.controller;

import com.multitaskchatbot.model.WeatherAdvice;
import com.multitaskchatbot.service.WeatherAdvisorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class WeatherAdvisorController {
    private WeatherAdvisorService weatherAdvisorService;

    WeatherAdvisorController(WeatherAdvisorService weatherAdvisorService) {
        this.weatherAdvisorService = weatherAdvisorService;

    }

    @GetMapping("/advice")
    public ResponseEntity<WeatherAdvice> getWeather(@RequestParam("message") String message) {
        return ResponseEntity.ok(weatherAdvisorService.getAdvice(message));

    }

    @GetMapping("/stream-advice")
    public ResponseEntity<Flux<String>> getStreamWeather(@RequestParam("message") String message) {
        return ResponseEntity.ok(weatherAdvisorService.getWeatherStream(message));

    }
}
