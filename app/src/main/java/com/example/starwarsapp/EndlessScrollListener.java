package com.example.starwarsapp;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class EndlessScrollListener extends RecyclerView.OnScrollListener {

    private int visibleThreshold = 5;
    private int currentPage = 0;
    private int previousTotalItemCount = 0;
    private int startingPageIndex = 0;
    private boolean loading = true;

    private LinearLayoutManager layoutManager;

    public EndlessScrollListener(int visibleThreshold, int startPage) {
        this.visibleThreshold = visibleThreshold;
        this.startingPageIndex = startPage;
        this.currentPage = startPage;
    }

    public EndlessScrollListener(LinearLayoutManager layoutManager, int visibleThreshold, int startPage) {
        this.layoutManager = layoutManager;
        this.visibleThreshold = visibleThreshold;
        this.startingPageIndex = startPage;
        this.currentPage = startPage;
    }

    @Override
    public void onScrolled(RecyclerView view, int dx, int dy) {
        super.onScrolled(view, dx, dy);

        RecyclerView.LayoutManager layoutManager = view.getLayoutManager();

        int lastVisibleItemPosition = 0;
        int totalItemCount = layoutManager.getItemCount();

        if(totalItemCount < previousTotalItemCount) {
            currentPage = startingPageIndex;
            previousTotalItemCount = totalItemCount;

            if(totalItemCount == 0) {
                loading = true;
            }

        }

        if(loading) {
            if(totalItemCount > previousTotalItemCount) {
                previousTotalItemCount = totalItemCount;
                loading = false;
            }
        }

        if (!loading) {
            if(lastVisibleItemPosition + visibleThreshold > totalItemCount) {
                loadMorePeopleItems(currentPage + 1, totalItemCount, view);
                loading = true;
            }
        }

    }

    public abstract void loadMorePeopleItems(int page, int totalItemsCount, RecyclerView view);

}
