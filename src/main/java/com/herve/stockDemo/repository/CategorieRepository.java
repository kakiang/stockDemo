package com.herve.stockDemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.herve.stockDemo.entities.Categorie;
import com.herve.stockDemo.projections.CategorieRecord;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{
    // Optional<Categorie> findByCode(String code);
    // Optional<Categorie> findByNom(String nom);

    @Query("SELECT c FROM Categorie c")
    List<CategorieRecord> findAllCategories();
}
