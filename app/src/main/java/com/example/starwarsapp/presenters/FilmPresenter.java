package com.example.starwarsapp.presenters;

import android.util.Log;
import android.widget.Toast;

import com.example.starwarsapp.adapters.FilmAdapter;
import com.example.starwarsapp.models.Film;
import com.example.starwarsapp.models.Result;
import com.example.starwarsapp.services.FilmService;
import com.example.starwarsapp.services.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FilmPresenter implements FilmPresenterContract.presenter {

    private final String TAG = "FilmPresenter";

    private Retrofit retrofit;
    private FilmService filmService;
    private FilmPresenterContract.view view;

    private List<Film> results;

    public FilmPresenter(FilmPresenterContract.view view){
        this.view = view;
        this.retrofit = RetrofitClient.getInstance();
        this.filmService = retrofit.create(FilmService.class);
        this.results = new ArrayList<>();
    }

    @Override
    public void getFilm() {
        results.clear();
        if(results.size() == 0) {
            fetchFilmResults("", 1);
        }
        view.onPrepareRecyclerView(new FilmAdapter(results));
    }

    @Override
    public void getFilmByTitle(String title){
        results.clear();
        if(!title.isEmpty()) {
            fetchFilmResults(title, 1);
        }
        view.onPrepareRecyclerView(new FilmAdapter(results));
    }

    private void fetchFilmResults(String title, int pageIndex){

        Call<Result> call = filmService.getFilm(title, pageIndex);
        Gson gson = new Gson();

        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.isSuccessful()){
                    if(response.body().getNext() == null){
                        for(JsonObject item: response.body().getResults()){
                            results.add(gson.fromJson(item, Film.class));
                        }
                    }else{
                        for(JsonObject item: response.body().getResults()){
                            results.add(gson.fromJson(item, Film.class));
                        }
                        fetchFilmResults(title, pageIndex + 1);
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
    public void getFilmById(int id) {

        Call<Film> call = filmService.getFilmById(id);

        call.enqueue(new Callback<Film>(){
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if(response.isSuccessful()){
                    Film film = response.body();
                }else{
                    Log.e(TAG, "Error: " + response.code());
                    Toast.makeText(view.getContext(), "Resource not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
            }
        });
    }
}
