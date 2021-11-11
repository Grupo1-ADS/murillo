package com.example.starwarsapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.starwarsapp.EndlessScrollListener;
import com.example.starwarsapp.R;

import com.example.starwarsapp.adapters.PeopleAdapter;
import com.example.starwarsapp.models.people.People;
import com.example.starwarsapp.contracts.PeopleContract;
import com.example.starwarsapp.presenters.PeoplePresenter;
import com.example.starwarsapp.services.PeopleService;

import java.util.List;

public class PeopleActivity extends AppCompatActivity implements PeopleContract.View, PeopleContract.OnItemClickListener {

    private RecyclerView recycler;
    private PeopleAdapter adapter;
    private PeoplePresenter presenter;

    private RecyclerView.OnScrollListener listener; // VERIFICAR

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        prepareRecyclerView();

        presenter = new PeoplePresenter(this, new PeopleService());
        presenter.requestDataFromSWAPI();

    }

    @Override
    public void prepareRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler = findViewById(R.id.rv_planets);

        recycler.setLayoutManager(layoutManager);
        recycler.setHasFixedSize(true);
    }

    @Override
    public void setDataToRecyclerView(List<People> peoples) {
        this.adapter = new PeopleAdapter(peoples);
        this.adapter.setOnItemClickListener(this);
        this.recycler.setAdapter(adapter);
        //this.adapter.notifyDataSetChanged();
    }

    @Override
    public void onResponseFailure(Throwable t) {
        Toast.makeText(this,"Something went wrong..." + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }










    @Override
    public void onItemClick(People people) {
        Intent intent = new Intent(getApplicationContext(), PeopleDetailActivity.class);
        intent.putExtra("people", people);

        startActivity(intent);
    }

    public EndlessScrollListener onScrollListener(LinearLayoutManager layoutManager, int visibleThreshold, int startPage) {
        return new EndlessScrollListener(layoutManager, visibleThreshold, startPage) {
            @Override
            public void loadMorePeopleItems(int page, int totalItemsCount, RecyclerView view) {
                //peoplePresenter.getPeople(page);
            }
        };
    }

}