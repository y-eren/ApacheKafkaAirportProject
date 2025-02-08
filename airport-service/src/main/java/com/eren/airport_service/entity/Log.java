package com.eren.airport_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="log")
@Getter
@Setter
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String topic;

    @Column
    private String content;

    @Column
    private LocalDateTime timeStamp;



}
