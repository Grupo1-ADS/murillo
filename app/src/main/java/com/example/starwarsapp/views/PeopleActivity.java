package com.example.starwarsapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.starwarsapp.R;

import com.example.starwarsapp.adapters.PeopleAdapter;
import com.example.starwarsapp.presenters.PeoplePresenter;
import com.example.starwarsapp.presenters.PeoplePresenterContract;

public class PeopleActivity extends AppCompatActivity implements PeoplePresenterContract.view {

    private PeoplePresenterContract.presenter presenter;
    private PeopleAdapter adapter;

    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        presenter = new PeoplePresenter(this);

        recycler = findViewById(R.id.recyclerPlanets);
        EditText editText = findViewById(R.id.etFilmsSearch);
        Button buttonSearch = findViewById(R.id.btnFilmsSearch);

        onPrepareRecyclerView(adapter);
        presenter.getPeople();

        buttonSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                System.out.println("EDIT TEXT" + editText.getText().toString());
                presenter.getPeopleByName(editText.getText().toString());
            }
        });
    }

    @Override
    public void onPrepareRecyclerView(RecyclerView.Adapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(PeopleActivity.this);

        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);
    }

    @Override
    public void clearRecyclerView() {
        recycler.setAdapter(null);
    }

    @Override
    public Context getContext() {
        return PeopleActivity.this;
    }

}