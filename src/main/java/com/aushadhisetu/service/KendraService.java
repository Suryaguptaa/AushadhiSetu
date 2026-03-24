package com.aushadhisetu.service;

import com.aushadhisetu.entity.Kendra;
import com.aushadhisetu.repository.KendraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KendraService {

    private final KendraRepository kendraRepository;

    public KendraService(KendraRepository kendraRepository){
        this.kendraRepository = kendraRepository;
    }

    public Kendra getKendraById(Long id) {
        return kendraRepository.findById(id).orElse(null);
    }

    public List<Kendra> getKendraByCity(String city){
        return kendraRepository.findByCity(city);
    }

    public Kendra registerKendra(Kendra kendra){
        return kendraRepository.save(kendra);
    }


    public Kendra updatedKendra(Long id, Kendra kendra){
        Optional<Kendra> optionalKendra = kendraRepository.findById(id);

        if(optionalKendra.isEmpty()){
            return null;
        }
        Kendra existingKendra = optionalKendra.get();

        existingKendra.setName(kendra.getName());
        existingKendra.setCity(kendra.getCity());

        return kendraRepository.save(existingKendra);
    }
}