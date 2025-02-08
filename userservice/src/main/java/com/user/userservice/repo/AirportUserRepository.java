package com.user.userservice.repo;

import com.eren.airport_service.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportUserRepository extends JpaRepository<Airport, Integer> {
}
