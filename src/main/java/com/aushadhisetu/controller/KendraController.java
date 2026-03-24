package com.aushadhisetu.controller;

import com.aushadhisetu.entity.Kendra;
import com.aushadhisetu.service.KendraService;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kendras")
public class KendraController {

    private final KendraService kendraService;

    public KendraController(KendraService kendraService) {
        this.kendraService = kendraService;
    }

    //GET Kendra by ID
    @GetMapping("/{id}")
    public ResponseEntity<?>getKendraById(@PathVariable Long id){
        Kendra kendra = kendraService.getKendraById(id);
        if(kendra==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(kendra);
    }

    //Get Kendra by City
    @GetMapping("/city/{city}")
    public ResponseEntity<?> getKendrasByCity(@RequestParam String city){
        List<Kendra> kendras = kendraService.getKendraByCity(city);
        return ResponseEntity.ok(kendras);
    }

        //Register new Kendra
        @PostMapping
        public ResponseEntity<Kendra> registerKendra(@RequestBody Kendra kendra){
    //        Kendra savedKendra = kendraService.registerKendra(kendra);
            Kendra savedKendra = kendraService.registerKendra(kendra);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedKendra);
        }

    //update existing Kendras
    @PutMapping("/{id}")
    public ResponseEntity<?> updatedKendra(
            @PathVariable Long id,
            @RequestBody Kendra kendra
    ){
        Kendra updatedKendra = kendraService.updatedKendra(id,kendra);

        if(updatedKendra == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedKendra);
    }
}