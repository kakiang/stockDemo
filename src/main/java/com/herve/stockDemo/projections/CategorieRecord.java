package com.herve.stockDemo.projections;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CategorieRecord(
    @JsonProperty("code_categorie") String codeCategorie, 
    @JsonProperty("nom_categorie") String nomCategorie) {

}
