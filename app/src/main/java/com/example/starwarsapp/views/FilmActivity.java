package com.example.starwarsapp.views;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwarsapp.R;
import com.example.starwarsapp.adapters.FilmAdapter;
import com.example.starwarsapp.presenters.FilmPresenter;
import com.example.starwarsapp.presenters.FilmPresenterContract;

public class FilmActivity extends AppCompatActivity implements FilmPresenterContract.view {

    private FilmPresenterContract.presenter presenter;
    private FilmAdapter adapter;

    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);

        presenter = new FilmPresenter(this);

        recycler = findViewById(R.id.recyclerPlanets);
        EditText etFilmsSearch = findViewById(R.id.etFilmsSearch);
        Button btnFilmsSearch = findViewById(R.id.btnFilmsSearch);

        onPrepareRecyclerView(adapter);
        presenter.getFilm();

        btnFilmsSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                presenter.getFilmByTitle(etFilmsSearch.getText().toString());
            }
        });
    }

    @Override
    public void onPrepareRecyclerView(RecyclerView.Adapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(FilmActivity.this);

        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);
    }

    @Override
    public void clearRecyclerView() {
        recycler.setAdapter(null);
    }

    @Override
    public Context getContext() {
        return FilmActivity.this;
    }

}