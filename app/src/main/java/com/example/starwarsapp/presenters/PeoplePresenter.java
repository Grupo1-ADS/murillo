package com.example.starwarsapp.presenters;

import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.starwarsapp.adapters.PeopleAdapter;
import com.example.starwarsapp.models.Result;
import com.example.starwarsapp.models.People;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import com.example.starwarsapp.services.RetrofitClient;
import com.example.starwarsapp.services.PeopleService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class PeoplePresenter implements PeoplePresenterContract.presenter {

    private final String TAG = "PeoplePresenter";

    private Retrofit retrofit;
    private PeopleService peopleService;
    private PeoplePresenterContract.view view;

    private List<People> results;

    public PeoplePresenter(PeoplePresenterContract.view view){
        this.view = view;
        this.retrofit = RetrofitClient.getInstance();
        this.peopleService = retrofit.create(PeopleService.class);
        this.results = new ArrayList<>();
    }

    @Override
    public void getPeople() {
        results.clear();
        if(results.size() == 0) {
            fetchPeopleResults("", 1);
        }
        view.onPrepareRecyclerView(new PeopleAdapter(results));
    }

    @Override
    public void getPeopleByName(String name){
        results.clear();
        if(!name.isEmpty()) {
            fetchPeopleResults(name, 1);
        }
        view.onPrepareRecyclerView(new PeopleAdapter(results));
    }

    private void fetchPeopleResults(String name, int pageIndex){

        Call<Result> call = peopleService.getPeople(name, pageIndex);
        Gson gson = new Gson();

        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.isSuccessful()){
                    if(response.body().getNext() == null){
                        for(JsonObject item: response.body().getResults()){
                            results.add(gson.fromJson(item, People.class));
                        }
                    }else{
                        for(JsonObject item: response.body().getResults()){
                            results.add(gson.fromJson(item, People.class));
                        }
                        fetchPeopleResults(name, pageIndex + 1);
                    }
                }else{
                    Log.e(TAG, "Error: " + response.code());
                    Toast.makeText(view.getContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
            }
        });
    }

    @Override
    public void getPeopleById(int id) {

        Call<People> call = peopleService.getPeopleById(id);

        call.enqueue(new Callback<People>(){
            @Override
            public void onResponse(Call<People> call, Response<People> response) {
                if(response.isSuccessful()){
                    People people = response.body();
                }else{
                    Log.e(TAG, "Error: " + response.code());
                    Toast.makeText(view.getContext(), "Resource not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<People> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
            }
        });
    }
}
