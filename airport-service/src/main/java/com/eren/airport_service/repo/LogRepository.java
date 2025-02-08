package com.eren.airport_service.repo;

import com.eren.airport_service.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Integer> {
}
