package com.example.starwarsapp.presenters;

import com.example.starwarsapp.contracts.PeopleContract;
import com.example.starwarsapp.models.people.People;

import java.util.List;

public class PeoplePresenter implements PeopleContract.Presenter, PeopleContract.Service.OnFinishedListener {

    private final String TAG = "PeoplePresenter";

    private PeopleContract.View view;
    private PeopleContract.Service service;

    private PeopleContract.Service.OnFinishedListener onFinishedListener;

    public PeoplePresenter(PeopleContract.View view, PeopleContract.Service service){
        this.view = view;
        this.service = service;
    }

    @Override
    public void requestDataFromSWAPI() {
        if(view != null) {
            service.getPeople(this, 1);
        }
    }

    @Override
    public void loadMoreDataFromSWAPI(int page) {
        if(view != null) {
            service.getPeople(this, page);
        }
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }

    @Override
    public void onFinished(List<People> peoples) {
        if(view != null) {
            view.setDataToRecyclerView(peoples);
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(view != null) {
            view.onResponseFailure(t);
        }
    }

}
