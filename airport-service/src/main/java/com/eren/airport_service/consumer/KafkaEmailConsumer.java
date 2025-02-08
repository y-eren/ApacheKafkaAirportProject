package com.eren.airport_service.consumer;


import com.eren.airport_service.entity.Airport;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class KafkaEmailConsumer {

    @Autowired
    private JavaMailSender mailSender;

    @KafkaListener(topics="topic1", groupId = "email_group")
    public void consume(String message) throws JsonProcessingException {
        Airport airport = new ObjectMapper().readValue(message, Airport.class);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("nefikox941@matmayer.com");
        mailMessage.setSubject("Airport Service");
        mailMessage.setText("Güncellenen havalimanı bilgisi" + message);
        mailSender.send(mailMessage);

        System.out.println("Eposta gönderildi");
    }
}
