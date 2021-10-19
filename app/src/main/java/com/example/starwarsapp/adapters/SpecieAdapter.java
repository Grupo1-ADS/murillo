package com.example.starwarsapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwarsapp.R;
import com.example.starwarsapp.models.Specie;

import java.util.List;

public class SpecieAdapter extends RecyclerView.Adapter<SpecieAdapter.ViewHolder> {

    private List<Specie> species;

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

    public SpecieAdapter(List<Specie> species){
        this.species = species;
    }

    @NonNull
    @Override
    public SpecieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_species, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.bind(films.get(position));
        Specie specie = species.get(position);

        TextView tv = holder.view.findViewById(R.id.tvNameSpecie);
        tv.setText(specie.getName());

    }

    @Override
    public int getItemCount() {
        return species.size();
    }

}
