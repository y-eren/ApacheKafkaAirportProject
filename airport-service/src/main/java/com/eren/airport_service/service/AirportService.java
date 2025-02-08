package com.eren.airport_service.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.eren.airport_service.entity.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.eren.airport_service.repo.AirportRepository;

import java.util.List;

@Service
public class AirportService {


    @Autowired
    AirportRepository airportRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;


    public Airport createAirport(Airport airport) {
        Airport created =  airportRepository.save(airport);
        return created;
        }

    public Airport getAirport(Integer id) {
        Airport airport = airportRepository.getAirportsById(id);
        return airport;
    }

    public Airport updateAirport(Integer id, Airport airport) {
        Airport updated = airportRepository.findById(id).orElseThrow(() -> new RuntimeException("Airport bulunamadi"));
        updated.setName(airport.getName());
        updated.setCity(airport.getCity());
        updated.setCountry(airport.getCountry());
        updated.setCode(airport.getCode());

       Airport saved =  airportRepository.save(updated);
        try {
            String message = objectMapper.writeValueAsString(saved);
//            String message = "Havaalanı güncellendi ismi :" + saved.getName() +
//                    "Havaalanı  ülkesi :" + saved.getCountry() +
//                    "Havaalanı ülke kodu :" + saved.getCode() +
//                    "Havaalanı  şehri :" + saved.getCity();
            kafkaTemplate.send("topic1", "airport-id-" + airport.getId(), message);

        } catch(Exception e) {
            throw new RuntimeException("Kafka mesaj gönderim hatası", e);
        }
        return saved;
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }








}
