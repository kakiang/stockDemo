package com.herve.stockDemo.service;

import java.util.List;
import java.util.Optional;

import com.herve.stockDemo.entities.Produit;
import com.herve.stockDemo.projections.ProduitRecord;

public interface ProduitService {
    List<Produit> getAllProduits();
    Produit getProduitsByCode(String code);
    Produit getProduitsByNom(String nom);
    Optional<Produit> createProduit(Produit produit, Long categoryId);
    Produit updateProduit(Long id, Produit produitDetails, Long categoryId);
    void deleteById(Long id);

    List<Produit> getProduitsByCategorieId(Long categorieId);
    List<Produit> getProduitsByCategorieNom(String categorieNom);

    List<ProduitRecord> getAllProduitsWithCategorie();
}
