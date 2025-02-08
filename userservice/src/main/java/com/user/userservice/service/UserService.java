package com.user.userservice.service;


import com.eren.airport_service.entity.Airport;

import com.user.userservice.repo.AirportUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    AirportUserRepository airportUserRepository;

    public List<Airport> getAllAirports() {
        return airportUserRepository.findAll();
    }




}
