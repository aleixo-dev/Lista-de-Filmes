package com.nicolas.listadefilmes.data.model.network.response;

import com.squareup.moshi.Json;

public class FilmeResponse {

    @Json(name = "poster_path")
    private final String caminhoPoster;

    @Json(name = "original_title")
    private final String tituloFinal;

    public FilmeResponse(String caminhoPoster, String tituloFinal) {
        this.caminhoPoster = caminhoPoster;
        this.tituloFinal = tituloFinal;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getTituloFinal() {
        return tituloFinal;
    }
}
