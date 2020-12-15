package com.nicolas.listadefilmes.ui;

import com.nicolas.listadefilmes.data.model.Filme;

import java.util.List;

public interface ListaFilmesContrato {

    interface ListaFilmesView {

        void mostraFilmes(List<Filme> filmes);

        void mostraErro();
    }

    interface ListaFilmesPresenter {

        void obtemFilmes();

        void destruirView();
    }

}
