package com.example.prog2.recyclerviewdatabinding;

import com.example.prog2.recyclerviewdatabinding.Data.Data;
import com.example.prog2.recyclerviewdatabinding.Model.NoticeData;

import java.util.ArrayList;

public class MainPresenter implements MainContract.presenter, MainContract.GetNoticeIntractor.OnFinishedListener{

    private MainContract.MainView mainView;
    private MainContract.GetNoticeIntractor intractor;

    public MainPresenter(MainContract.MainView mainView, MainContract.GetNoticeIntractor intractor) {
        this.mainView = mainView;
        this.intractor = intractor;
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onRefreshButtonClick() {
        if(mainView != null)
            mainView.showProgress();

        intractor.getNoticeArrayList(this, Data.list);
    }

    @Override
    public void requestDataFromServer() {
        intractor.getNoticeArrayList(this, Data.list);
    }

    @Override
    public void onFinished(ArrayList<NoticeData> noticeArrayList) {
        if(mainView != null){
            mainView.setDataToRecyclerView(noticeArrayList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}
