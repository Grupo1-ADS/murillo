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
import com.example.starwarsapp.adapters.PlanetAdapter;
import com.example.starwarsapp.presenters.PlanetPresenter;
import com.example.starwarsapp.presenters.PlanetPresenterContract;

public class PlanetActivity extends AppCompatActivity implements PlanetPresenterContract.view {

    private PlanetPresenterContract.presenter presenter;
    private PlanetAdapter adapter;

    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);

        presenter = new PlanetPresenter(this);

        recycler = findViewById(R.id.recyclerPlanets);
        EditText etPlanetsSearch = findViewById(R.id.tvTitleFilm);
        Button btnPlanetsSearch = findViewById(R.id.btnSpeciesSearch);

        onPrepareRecyclerView(adapter);
        presenter.getPlanet();

        btnPlanetsSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                presenter.getPlanetByName(etPlanetsSearch.getText().toString());
            }
        });
    }

    @Override
    public void onPrepareRecyclerView(RecyclerView.Adapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(PlanetActivity.this);

        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);
    }

    @Override
    public void clearRecyclerView() {
        recycler.setAdapter(null);
    }

    @Override
    public Context getContext() {
        return PlanetActivity.this;
    }

}