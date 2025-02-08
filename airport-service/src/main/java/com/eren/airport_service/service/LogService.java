package com.eren.airport_service.service;


import com.eren.airport_service.entity.Log;
import com.eren.airport_service.repo.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    @KafkaListener(topics = "topic1", groupId = "group_id")
    public void listen(String message) {
        Log log = new Log();
        log.setContent(message);
        log.setTopic("topic1");
        log.setTimeStamp(LocalDateTime.now());
        logRepository.save(log);
        System.out.println("Mesaj loglandı");


    }
}
