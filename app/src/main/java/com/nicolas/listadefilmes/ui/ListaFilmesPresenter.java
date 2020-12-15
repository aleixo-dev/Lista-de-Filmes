package com.nicolas.listadefilmes.ui;

import com.nicolas.listadefilmes.data.mapper.FilmeMapper;
import com.nicolas.listadefilmes.data.model.Filme;
import com.nicolas.listadefilmes.data.model.network.ApiService;
import com.nicolas.listadefilmes.data.model.network.response.FilmesResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesPresenter implements ListaFilmesContrato.ListaFilmesPresenter {

    private ListaFilmesContrato.ListaFilmesView view;

    public ListaFilmesPresenter(ListaFilmesContrato.ListaFilmesView view) {
        this.view = view;
    }


    @Override
    public void obtemFilmes() {

        ApiService.getInstance()
                .obterFilmesPopulares("cead12b729988cec6e29f8bfd5d35116")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {
                        if (response.isSuccessful()) {

                            final List<Filme> listaFilmes = FilmeMapper
                                    .doResponseParaDominio(response.body().getResultadosFilmes());

                            view.mostraFilmes(listaFilmes);
                        } else {
                            view.mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmesResult> call, Throwable t) {
                        view.mostraErro();
                    }
                });
    }

    @Override
    public void destruirView() {
        this.view = null;
    }
}
