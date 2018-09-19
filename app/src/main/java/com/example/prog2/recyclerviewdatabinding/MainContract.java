package com.example.prog2.recyclerviewdatabinding;


import com.example.prog2.recyclerviewdatabinding.Model.NoticeData;

import java.util.ArrayList;
import java.util.List;

public interface MainContract {

    interface presenter {

        void onDestroy();

        void onRefreshButtonClick();

        void requestDataFromServer();

    }

    interface MainView {
        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(ArrayList<NoticeData> noticeArrayList);

        void onResponseFailure(Throwable throwable);
    }

    interface GetNoticeIntractor {
        interface OnFinishedListener {
            void onFinished(ArrayList<NoticeData> noticeArrayList);

            void onFailure(Throwable t);
        }

        void getNoticeArrayList(OnFinishedListener onFinishedListener, List<NoticeData> list);
    }


}


