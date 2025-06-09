package com.herve.stockDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herve.stockDemo.entities.Categorie;
import com.herve.stockDemo.projections.CategorieRecord;
import com.herve.stockDemo.repository.CategorieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategorieServiceImpl {

    private final CategorieRepository categorieRepository;

    public List<Categorie> findAllCategories() {
        return categorieRepository.findAll();
    }

    public List<CategorieRecord> getAllCategories() {
        return categorieRepository.findAllCategories();
    }

    public Optional<Categorie> getCategorieById(Long id) {
        return categorieRepository.findById(id);
    }

    // public Optional<Categorie> getCategorieByCode(String code) {
    //     return categorieRepository.findByCode(code);
    // }

    // public Optional<Categorie> getCategorieByNom(String nom) {
    //     return categorieRepository.findByNom(nom);

    // }

    @Transactional
    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Transactional
    public Optional<Categorie> updateCategorie(Long id, Categorie categorieDetails) {
        return categorieRepository.findById(id)
                .map(categorie -> {
                    categorie.setCodeCategorie(categorieDetails.getCodeCategorie());
                    categorie.setNomCategorie(categorieDetails.getNomCategorie());
                    return categorieRepository.save(categorie);
                });
    }

    @Transactional
    public boolean deleteCategorie(Long id) {
        return categorieRepository.findById(id).map(categorie -> {
            if (!categorie.getProduits().isEmpty()) {
                // throw new IllegalStateException("Impossible de supprimer une categorie avec des produits associés");
                return false;
            }
            categorieRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

}
