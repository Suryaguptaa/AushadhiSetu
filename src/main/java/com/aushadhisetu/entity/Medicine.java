package com.aushadhisetu.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;


@Entity
@Data
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String genericName;

    private String category;

    private BigDecimal marketPrice;

    private BigDecimal janAushadhiPrice;

    private String manufacturer;

    private String description;
}