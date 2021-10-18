package com.example.starwarsapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwarsapp.R;

import com.example.starwarsapp.models.People;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    private List<People> peoples;

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

    public PeopleAdapter(List<People> peoples){
        this.peoples = peoples;
    }

    @NonNull
    @Override
    public PeopleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_people, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.bind(peopleList.get(position));
        People people = peoples.get(position);

        TextView tv = holder.view.findViewById(R.id.textView11);
        tv.setText(people.getName());

    }

    @Override
    public int getItemCount() {
        return peoples.size();
    }

}
