package com.example.starwarsapp.presenters;

import android.util.Log;
import android.widget.Toast;

import com.example.starwarsapp.adapters.SpecieAdapter;
import com.example.starwarsapp.models.Specie;
import com.example.starwarsapp.models.Result;
import com.example.starwarsapp.services.SpecieService;
import com.example.starwarsapp.services.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SpeciePresenter implements SpeciePresenterContract.presenter {

    private final String TAG = "SpeciePresenter";

    private Retrofit retrofit;
    private SpecieService specieService;
    private SpeciePresenterContract.view view;

    private List<Specie> results;

    public SpeciePresenter(SpeciePresenterContract.view view){
        this.view = view;
        this.retrofit = RetrofitClient.getInstance();
        this.specieService = retrofit.create(SpecieService.class);
        this.results = new ArrayList<>();
    }

    @Override
    public void getSpecies() {
        results.clear();
        if(results.size() == 0) {
            fetchSpecieResults("", 1);
        }
        view.onPrepareRecyclerView(new SpecieAdapter(results));
    }

    @Override
    public void getSpeciesByName(String name){
        results.clear();
        if(!name.isEmpty()) {
            fetchSpecieResults(name, 1);
        }
        view.onPrepareRecyclerView(new SpecieAdapter(results));
    }

    private void fetchSpecieResults(String name, int pageIndex){

        Call<Result> call = specieService.getSpecies(name, pageIndex);
        Gson gson = new Gson();

        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.isSuccessful()){
                    if(response.body().getNext() == null){
                        for(JsonObject item: response.body().getResults()){
                            results.add(gson.fromJson(item, Specie.class));
                        }
                    }else{
                        for(JsonObject item: response.body().getResults()){
                            results.add(gson.fromJson(item, Specie.class));
                        }
                        fetchSpecieResults(name, pageIndex + 1);
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
    public void getSpecieById(int id) {

        Call<Specie> call = specieService.getSpecieById(id);

        call.enqueue(new Callback<Specie>(){
            @Override
            public void onResponse(Call<Specie> call, Response<Specie> response) {
                if(response.isSuccessful()){
                    Specie specie = response.body();
                }else{
                    Log.e(TAG, "Error: " + response.code());
                    Toast.makeText(view.getContext(), "Resource not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Specie> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
            }
        });
    }
}
