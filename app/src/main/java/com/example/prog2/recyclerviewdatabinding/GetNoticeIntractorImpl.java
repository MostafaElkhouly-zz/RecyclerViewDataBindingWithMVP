package com.example.prog2.recyclerviewdatabinding;

import com.example.prog2.recyclerviewdatabinding.Model.NoticeData;

import java.util.ArrayList;
import java.util.List;

public class GetNoticeIntractorImpl implements MainContract.GetNoticeIntractor {

    @Override
    public void getNoticeArrayList(OnFinishedListener onFinishedListener, List<NoticeData> list) {
        onFinishedListener.onFinished(new ArrayList(list));
    }
}
