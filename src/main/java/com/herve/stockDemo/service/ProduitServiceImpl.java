package com.herve.stockDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.herve.stockDemo.entities.Produit;
import com.herve.stockDemo.exception.ResourceNotFoundException;
import com.herve.stockDemo.projections.ProduitRecord;
import com.herve.stockDemo.repository.CategorieRepository;
import com.herve.stockDemo.repository.ProduitRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;
    private final CategorieRepository categorieRepository;

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public List<ProduitRecord> getAllProduitsWithCategorie(){
        return produitRepository.getAllProduitsWithCategorie();
    }

    @Override
    public Produit getProduitsByCode(String code) {
        return produitRepository.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Aucun produit avec code=" + code));
    }

    @Override
    public Produit getProduitsByNom(String nom) {
        return produitRepository.findByNom(nom)
                .orElseThrow(() -> new ResourceNotFoundException("Aucun produit avec nom=" + nom));
    }

    @Override
    @Transactional
    public Optional<Produit> createProduit(Produit produit, Long categoryId) {
        return categorieRepository.findById(categoryId).map(category -> {
            produit.setCategorie(category);
            return produitRepository.save(produit);
        });
    }

    @Override
    @Transactional
    public Produit updateProduit(Long id, Produit produitDetails, Long categoryId) {
        Produit produitExistant = produitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aucun produit avec id=" + id));
        produitExistant.setCode(produitDetails.getCode());
        produitExistant.setNom(produitDetails.getNom());
        if(categoryId!=null){
            categorieRepository.findById(categoryId).ifPresent(produitExistant::setCategorie);
        }
        produitExistant.setCategorie(produitDetails.getCategorie());
        return produitRepository.save(produitExistant);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!produitRepository.existsById(id)) {
            throw new ResourceNotFoundException("Aucun produit avec id=" + id);
        }
        produitRepository.deleteById(id);
    }

    @Override
    public List<Produit> getProduitsByCategorieId(Long categorieId) {
        return produitRepository.findByCategorie_Id(categorieId);
    }

    @Override
    public List<Produit> getProduitsByCategorieNom(String categorieNom) {
        return produitRepository.findByCategorie_NomCategorie(categorieNom);
    }

}
