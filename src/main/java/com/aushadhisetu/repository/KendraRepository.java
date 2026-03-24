package com.aushadhisetu.repository;

import com.aushadhisetu.entity.Kendra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KendraRepository extends JpaRepository<Kendra, Long> {

    List<Kendra> findByCity(String city);

}