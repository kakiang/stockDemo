package com.herve.stockDemo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herve.stockDemo.projections.ProduitRecord;
import com.herve.stockDemo.service.ProduitService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/produits")
@RequiredArgsConstructor
public class ProduitController {
    
    private final ProduitService produitService;
    
    @GetMapping
    public ResponseEntity<List<ProduitRecord>> getAllProduitsWithCategorie(){
        var all = produitService.getAllProduitsWithCategorie();
        return ResponseEntity.ok(all);
    }

}
