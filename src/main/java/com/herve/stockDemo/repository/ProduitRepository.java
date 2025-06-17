package com.herve.stockDemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.herve.stockDemo.entities.Produit;
import com.herve.stockDemo.projections.ProduitRecord;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    Optional<Produit> findByCode(String code);

    Optional<Produit> findByNom(String nom);

    List<Produit> findByCategorie_Id(Long categorieId);

    List<Produit> findByCategorie_NomCategorie(String categorieNom);

    @Query("""
            SELECT p.code, p.nom, p.categorie.codeCategorie, p.categorie.nomCategorie
            FROM Produit p
            """)
    List<ProduitRecord> getAllProduitsWithCategorie();

}
