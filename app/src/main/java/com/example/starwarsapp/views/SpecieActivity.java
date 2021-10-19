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
import com.example.starwarsapp.adapters.SpecieAdapter;
import com.example.starwarsapp.presenters.SpeciePresenter;
import com.example.starwarsapp.presenters.SpeciePresenterContract;

public class SpecieActivity extends AppCompatActivity implements SpeciePresenterContract.view {

    private SpeciePresenterContract.presenter presenter;
    private SpecieAdapter adapter;

    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species);

        presenter = new SpeciePresenter(this);

        recycler = findViewById(R.id.recyclerPlanets);
        EditText etSpeciesSearch = findViewById(R.id.tvTitleFilm);
        Button btnSpeciesSearch = findViewById(R.id.btnSpeciesSearch);

        onPrepareRecyclerView(adapter);
        presenter.getSpecies();

        btnSpeciesSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                presenter.getSpeciesByName(etSpeciesSearch.getText().toString());
            }
        });
    }

    @Override
    public void onPrepareRecyclerView(RecyclerView.Adapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(SpecieActivity.this);

        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);
    }

    @Override
    public void clearRecyclerView() {
        recycler.setAdapter(null);
    }

    @Override
    public Context getContext() {
        return SpecieActivity.this;
    }

}