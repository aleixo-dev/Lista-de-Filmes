package com.nicolas.listadefilmes.data.model.network.response;

import com.squareup.moshi.Json;

import java.util.List;

public class FilmesResult {

    @Json(name = "results")
    private final List<FilmeResponse> resultadosFilmes;

    public FilmesResult(List<FilmeResponse> resultadosFilmes) {
        this.resultadosFilmes = resultadosFilmes;
    }

    public List<FilmeResponse> getResultadosFilmes() {
        return resultadosFilmes;
    }
}
