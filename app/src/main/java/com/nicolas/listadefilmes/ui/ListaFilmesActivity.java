package com.nicolas.listadefilmes.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.nicolas.listadefilmes.R;
import com.nicolas.listadefilmes.data.mapper.FilmeMapper;
import com.nicolas.listadefilmes.data.model.Filme;
import com.nicolas.listadefilmes.data.model.network.ApiService;
import com.nicolas.listadefilmes.data.model.network.response.FilmesResult;
import com.nicolas.listadefilmes.ui.detalhesFilmes.DetalheFilmeActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity implements
        ListaFilmesContrato.ListaFilmesView, ListaFilmesAdapter.ItemFilmeClickListener {

    private ListaFilmesAdapter filmesAdapter;
    private ListaFilmesContrato.ListaFilmesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        configurarAdapter();

        presenter = new ListaFilmesPresenter(this);
        presenter.obtemFilmes();
    }

    private void configurarAdapter() {

        RecyclerView recyclerView = findViewById(R.id.recyclerFilmes);
        filmesAdapter = new ListaFilmesAdapter(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(filmesAdapter);
    }

    @Override
    public void mostraFilmes(List<Filme> filmes) {
        filmesAdapter.setFilmes(filmes);
    }

    @Override
    public void mostraErro() {
        Toast.makeText(this,
                "Erro ao obter lista de filmes."
                , Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destruirView();
    }

    @Override
    public void onItemFilmeClicado(Filme filme) {

        Intent intent = new Intent(this, DetalheFilmeActivity.class);
        intent.putExtra(DetalheFilmeActivity.EXTRA_FILME, filme);
        startActivity(intent);
    }
}