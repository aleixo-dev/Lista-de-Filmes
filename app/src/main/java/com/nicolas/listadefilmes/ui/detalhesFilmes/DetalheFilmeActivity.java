package com.nicolas.listadefilmes.ui.detalhesFilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.nicolas.listadefilmes.R;
import com.nicolas.listadefilmes.data.model.Filme;

public class DetalheFilmeActivity extends AppCompatActivity {

    public static final String EXTRA_FILME = "EXTRA_FILME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filme);

        TextView textTituloFilme = findViewById(R.id.text_titulo_filme);
        final Filme filme = (Filme) getIntent().getSerializableExtra(EXTRA_FILME);
        textTituloFilme.setText(filme.getTitulo());
    }
}