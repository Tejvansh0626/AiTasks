package com.multitaskchatbot.controller;

import com.multitaskchatbot.model.TravelPlan;
import com.multitaskchatbot.service.TravelPlannerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TravelPlannerController {
    private TravelPlannerService travelPlannerService;

    TravelPlannerController(TravelPlannerService travelPlannerService) {
        this.travelPlannerService = travelPlannerService;

    }

    @GetMapping("/plan")
    public ResponseEntity<TravelPlan> getPlan(@RequestParam("message") String message) {
        return ResponseEntity.ok(travelPlannerService.generatePlan(message));
    }

    @GetMapping("/stream-plan")
    public ResponseEntity<Flux<String>> getStreamPlan(@RequestParam("message") String message) {
        return ResponseEntity.ok(travelPlannerService.genrateStreamPlan(message));

    }
}
