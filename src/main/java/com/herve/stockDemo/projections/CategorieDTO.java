package com.herve.stockDemo.projections;

import java.util.List;

import lombok.Data;

@Data
public class CategorieDTO {
    private String code;
    private String nom;
    private List<ProduitDTO> produits;

    @Data
    public static class ProduitDTO {
        private String code;
        private String nom;
    }

}
