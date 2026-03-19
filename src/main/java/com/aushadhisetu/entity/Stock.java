package com.aushadhisetu.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    private LocalDateTime lastUpdated;

    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "kendra_id", nullable = false)
    private Kendra kendra;

    @ManyToOne
    @JoinColumn(name = "medicine_id", nullable = false)
    private Medicine medicine;
}