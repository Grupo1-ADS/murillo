package com.example.starwarsapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwarsapp.R;
import com.example.starwarsapp.models.Film;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    private List<Film> films;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public View getView(){
            return view;
        }
    }

    public FilmAdapter(List<Film> films){
        this.films = films;
    }

    @NonNull
    @Override
    public FilmAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_people, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.bind(films.get(position));
        Film film = films.get(position);

        TextView tv = holder.view.findViewById(R.id.tvTitleFilm);
        tv.setText(film.getTitle());

    }

    @Override
    public int getItemCount() {
        return films.size();
    }

}
