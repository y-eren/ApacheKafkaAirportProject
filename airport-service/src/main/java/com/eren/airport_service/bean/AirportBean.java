package com.eren.airport_service.bean;


import com.eren.airport_service.entity.Airport;
import com.eren.airport_service.service.AirportService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component("airportBean")
@ViewScoped
public class AirportBean implements Serializable {


    @Autowired
    private AirportService airportService;

    @Getter
    @Setter
    private Airport selectedAirport;
    @Getter
    @Setter
    private List<Airport> airports;

    @PostConstruct
    public void init() {
        airports = airportService.getAllAirports();
        selectedAirport = new Airport();
    }

//    public List<Airport> getAllAirports() {
//        airports = airportService.getAllAirports();
//        return airports;
//
//    }





}
