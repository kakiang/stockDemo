package com.herve.stockDemo.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.herve.stockDemo.entities.Categorie;
import com.herve.stockDemo.projections.CategorieRecord;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

    @Query("SELECT c FROM Categorie c JOIN FETCH c.produits")
    List<Categorie> findAllCategories();

    @Query("SELECT c FROM Categorie c")
    List<CategorieRecord> findAllCategorieRecords();
}
