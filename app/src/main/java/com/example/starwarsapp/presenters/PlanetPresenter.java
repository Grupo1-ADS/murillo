package com.example.starwarsapp.presenters;

import android.util.Log;
import android.widget.Toast;

import com.example.starwarsapp.adapters.PlanetAdapter;
import com.example.starwarsapp.models.Planet;
import com.example.starwarsapp.models.Result;
import com.example.starwarsapp.services.PlanetService;
import com.example.starwarsapp.services.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PlanetPresenter implements PlanetPresenterContract.presenter {

    private final String TAG = "PeoplePresenter";

    private Retrofit retrofit;
    private PlanetService planetService;
    private PlanetPresenterContract.view view;

    private List<Planet> results;

    public PlanetPresenter(PlanetPresenterContract.view view){
        this.view = view;
        this.retrofit = RetrofitClient.getInstance();
        this.planetService = retrofit.create(PlanetService.class);
        this.results = new ArrayList<>();
    }

    @Override
    public void getPlanet() {
        results.clear();
        if(results.size() == 0) {
            fetchPlanetResults("", 1);
        }
        view.onPrepareRecyclerView(new PlanetAdapter(results));
    }

    @Override
    public void getPlanetByName(String name){
        results.clear();
        if(!name.isEmpty()) {
            fetchPlanetResults(name, 1);
        }
        view.onPrepareRecyclerView(new PlanetAdapter(results));
    }

    private void fetchPlanetResults(String name, int pageIndex){

        Call<Result> call = planetService.getPlanets(name, pageIndex);
        Gson gson = new Gson();

        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.isSuccessful()){
                    if(response.body().getNext() == null){
                        for(JsonObject item: response.body().getResults()){
                            results.add(gson.fromJson(item, Planet.class));
                        }
                    }else{
                        for(JsonObject item: response.body().getResults()){
                            results.add(gson.fromJson(item, Planet.class));
                        }
                        fetchPlanetResults(name, pageIndex + 1);
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
    public void getPlanetById(int id) {

        Call<Planet> call = planetService.getPlanetById(id);

        call.enqueue(new Callback<Planet>(){
            @Override
            public void onResponse(Call<Planet> call, Response<Planet> response) {
                if(response.isSuccessful()){
                    Planet planet = response.body();
                }else{
                    Log.e(TAG, "Error: " + response.code());
                    Toast.makeText(view.getContext(), "Resource not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Planet> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
            }
        });
    }
}
