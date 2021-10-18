package com.example.starwarsapp.presenters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.starwarsapp.models.People;
import com.google.gson.JsonObject;

import java.util.List;

public interface PeoplePresenterContract {

    interface view {

        public void onPrepareRecyclerView(RecyclerView.Adapter adapter);
        public void clearRecyclerView();
        public Context getContext();

    }

    interface presenter {

        public void getPeople();
        public void getPeopleByName(String name);
        public void getPeopleById(int id);

    }

}
