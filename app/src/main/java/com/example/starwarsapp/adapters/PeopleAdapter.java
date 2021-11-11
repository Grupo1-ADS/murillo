package com.example.starwarsapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.starwarsapp.databinding.ItemPeopleBinding;
import com.example.starwarsapp.models.people.People;
import com.example.starwarsapp.contracts.PeopleContract;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    private List<People> peoples;
    private PeopleContract.OnItemClickListener onItemClickListener;

    public PeopleAdapter(List<People> peoples){
        this.peoples = peoples;
    }

    @Override
    public PeopleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemPeopleBinding itemBinding = ItemPeopleBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        People people = peoples.get(position);
        holder.bind(people);
    }

    @Override
    public int getItemCount() {
        return peoples != null ? peoples.size() : 0;
    }

    public void setOnItemClickListener(PeopleContract.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemPeopleBinding binding;

        public ViewHolder(ItemPeopleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(People people) {
            binding.setPeople(people);
            binding.setPeopleItemClick(onItemClickListener);
            binding.executePendingBindings();
        }

    }

}