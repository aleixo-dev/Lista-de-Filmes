package com.nicolas.listadefilmes.data.mapper;

import com.nicolas.listadefilmes.data.model.Filme;
import com.nicolas.listadefilmes.data.model.network.response.FilmeResponse;

import java.util.ArrayList;
import java.util.List;

public class FilmeMapper {

    public static List<Filme> doResponseParaDominio(List<FilmeResponse> responseList) {

        List<Filme> list = new ArrayList<>();

        for (FilmeResponse filmeResponse : responseList) {
            final Filme filme = new Filme(filmeResponse.getTituloFinal()
                    , filmeResponse.getCaminhoPoster());
            list.add(filme);
        }
        return list;
    }
}
