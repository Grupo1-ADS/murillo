package com.example.starwarsapp.contracts;

import com.example.starwarsapp.models.people.People;

import java.util.List;

public interface PeopleContract {

    interface View {

        void prepareRecyclerView();

        void setDataToRecyclerView(List<People> peoples);

        void onResponseFailure(Throwable t);

    }

    interface Presenter {

        void requestDataFromSWAPI();

        void loadMoreDataFromSWAPI(int page);

        void onDestroy();

    }

    interface Service {

        public void getPeople(PeopleContract.Service.OnFinishedListener onFinishedListener, int page);

        public void getPeopleByName(PeopleContract.Service.OnFinishedListener onFinishedListener, String name, int page);

        interface OnFinishedListener {

            void onFinished(List<People> peoples);

            void onFailure(Throwable t);

        }

    }

    interface OnItemClickListener {

        public void onItemClick(People people);

    }

}