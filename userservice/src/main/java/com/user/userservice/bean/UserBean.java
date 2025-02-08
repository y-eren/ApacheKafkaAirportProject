package com.user.userservice.bean;


import com.eren.airport_service.entity.Airport;
import com.eren.airport_service.service.AirportService;
import com.user.userservice.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component("userBean")
@ViewScoped
@Getter
@Setter
public class UserBean implements Serializable {
    private Integer id;
    private String name;
    private String city;
    private String country;
    private String code;

    private List<Airport> airports;
    private Airport selectedAirport;
    @Autowired
    UserService userService;

    @Autowired
    AirportService airportService;

    @PostConstruct
    public void init() {
        airports = userService.getAllAirports();
        selectedAirport = new Airport();
    }

    public void updateAirport() {
        airportService.updateAirport(
                selectedAirport.getId(),
                selectedAirport
        );
    }





}