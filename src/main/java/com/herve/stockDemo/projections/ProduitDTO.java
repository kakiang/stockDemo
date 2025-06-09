package com.herve.stockDemo.projections;

import lombok.Data;

@Data
public class ProduitDTO {
    private Long id;
    private String code;
    private String nom;
    private Long categorieId;
    private String categorieCode;
    private String categorieNom;

}
