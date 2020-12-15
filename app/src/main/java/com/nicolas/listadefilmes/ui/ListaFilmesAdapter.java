package com.nicolas.listadefilmes.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nicolas.listadefilmes.R;
import com.nicolas.listadefilmes.data.model.Filme;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.MyViewHolder> {

    private List<Filme> filmes;
    private final ItemFilmeClickListener itemFilmeClickListener;

    public ListaFilmesAdapter(ItemFilmeClickListener itemFilmeClickListener) {
        filmes = new ArrayList<>();
        this.itemFilmeClickListener = itemFilmeClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_filme, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(filmes.get(position));
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        ImageView imageViewPoster;
        private Filme filme;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPoster = itemView.findViewById(R.id.image_poster_filme);
            titulo = itemView.findViewById(R.id.text_titulo_filme);
            itemView.setOnClickListener(v -> {

                if (itemFilmeClickListener != null) {
                    itemFilmeClickListener.onItemFilmeClicado(filme);
                }
            });
        }

        public void bind(Filme filme) {

            this.filme = filme;
            titulo.setText(filme.getTitulo());
            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500" +
                            filme.getCaminhoPoster())
                    .into(imageViewPoster);
        }
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
        notifyDataSetChanged();
    }

    public interface ItemFilmeClickListener {
        void onItemFilmeClicado(Filme filme);
    }

}
