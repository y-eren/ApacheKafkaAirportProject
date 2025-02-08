package com.eren.airport_service.repo;


import com.eren.airport_service.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Integer> {

    Airport getAirportsById(Integer id);
}
