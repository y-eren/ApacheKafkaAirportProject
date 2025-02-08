package com.eren.airport_service.controller;


import com.eren.airport_service.entity.Airport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.eren.airport_service.service.AirportService;

@RestController
@RequestMapping("/api")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping("/save")
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        Airport created = airportService.createAirport(airport);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable("id") Integer id) {
        Airport airport = airportService.getAirport(id);
        return ResponseEntity.ok(airport);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable("id") Integer id, @RequestBody Airport airport) {
        Airport updated = airportService.updateAirport(id, airport);
        return ResponseEntity.ok(updated);
    }
}
