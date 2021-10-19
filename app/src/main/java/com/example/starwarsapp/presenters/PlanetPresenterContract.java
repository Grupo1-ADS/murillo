package com.example.starwarsapp.presenters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface PlanetPresenterContract {

    interface view {

        public void onPrepareRecyclerView(RecyclerView.Adapter adapter);
        public void clearRecyclerView();
        public Context getContext();

    }

    interface presenter {

        public void getPlanet();
        public void getPlanetByName(String name);
        public void getPlanetById(int id);

    }

}
