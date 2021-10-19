package com.example.starwarsapp.presenters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface SpeciePresenterContract {

    interface view {

        public void onPrepareRecyclerView(RecyclerView.Adapter adapter);
        public void clearRecyclerView();
        public Context getContext();

    }

    interface presenter {

        public void getSpecies();
        public void getSpeciesByName(String name);
        public void getSpecieById(int id);

    }

}
