package com.aushadhisetu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Kendra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String owner;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String city;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Pattern(regexp = "\\d{6}", message = "Pincode must be exactly 6 digits")
    @Column(length = 6, nullable = false)
    private String pincode;

    @Column(nullable = false)
    private LocalTime openingTime;
    @Column(nullable = false)
    private LocalTime closingTime;

    private boolean manuallyClosed;
    public boolean isOpenNow() {
        if (manuallyClosed) return false;

        LocalTime now = LocalTime.now();
        if (closingTime.isAfter(openingTime)) {
            return now.isAfter(openingTime) && now.isBefore(closingTime);
        } else {
            return now.isAfter(openingTime) || now.isBefore(closingTime);
        }
    }

    @OneToMany(mappedBy = "kendra", cascade = CascadeType.ALL)
    private List<Stock> stocks = new ArrayList<>();




}