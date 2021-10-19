package com.example.starwarsapp.presenters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface FilmPresenterContract {

    interface view {

        public void onPrepareRecyclerView(RecyclerView.Adapter adapter);
        public void clearRecyclerView();
        public Context getContext();

    }

    interface presenter {

        public void getFilm();
        public void getFilmByTitle(String title);
        public void getFilmById(int id);

    }

}
