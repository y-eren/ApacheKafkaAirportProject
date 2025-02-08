package com.eren.airport_service.consumer;


import com.eren.airport_service.websocket.WebSocketMessageHandler;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaWebSocketListener {

    @Autowired
    WebSocketMessageHandler webSocketHandler;

    @KafkaListener(topics = "topic1", groupId = "log_group")
    public void listen(String message) {
        webSocketHandler.sendMessageToAll(message);
    }


}
