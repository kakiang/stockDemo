package com.herve.stockDemo.service;

import com.herve.stockDemo.entities.Categorie;

import java.util.Optional;

public interface CategorieService {
    Categorie getCategorieByCode(String code);
    Categorie getCategorieByNom(String nom);

    Optional<Categorie> updateCategorie(Long id, Categorie categorieDetails);
    // boolean deleteCategorie(Long id);
}
