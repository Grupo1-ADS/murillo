package com.example.starwarsapp.services;

import android.util.Log;
import android.widget.Toast;

import com.example.starwarsapp.contracts.PeopleContract;
import com.example.starwarsapp.models.people.People;
import com.example.starwarsapp.models.people.PeopleResult;
import com.example.starwarsapp.networks.PeopleInterface;
import com.example.starwarsapp.networks.RetrofitClient;
import com.example.starwarsapp.presenters.PeoplePresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PeopleService implements PeopleContract.Service {

    private final String TAG = "PeopleService";
    private PeopleInterface service;

    public PeopleService() {
        Retrofit retrofit = RetrofitClient.getInstance();
        this.service = retrofit.create(PeopleInterface.class);
    }

    @Override
    public void getPeople(PeopleContract.Service.OnFinishedListener onFinishedListener, int page) {
        Call<PeopleResult> call = service.getPeople(page);
        fetchPeopleResults(onFinishedListener, call);
    }

    @Override
    public void getPeopleByName(PeopleContract.Service.OnFinishedListener onFinishedListener, String name, int page) {
        Call<PeopleResult> call = service.getPeopleByName(name, page);
        fetchPeopleResults(onFinishedListener, call);
    }

    private void fetchPeopleResults(PeopleContract.Service.OnFinishedListener onFinishedListener, Call<PeopleResult> call){
        call.enqueue(new Callback<PeopleResult>(){
            @Override
            public void onResponse(Call<PeopleResult> call, Response<PeopleResult> response) {
                if(response.isSuccessful()){
                    List<People> peoples = response.body().getResults();
                    onFinishedListener.onFinished(peoples);
                }else{
                    Log.e(TAG, "Error: " + response.code());
                    //Toast.makeText(view.getContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PeopleResult> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
                //onFinishedListener.onFailure(t);
            }
        });
    }

}