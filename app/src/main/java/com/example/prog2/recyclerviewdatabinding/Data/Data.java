package com.example.prog2.recyclerviewdatabinding.Data;

import com.example.prog2.recyclerviewdatabinding.Model.NoticeData;

import java.util.ArrayList;
import java.util.List;

public class Data {
    static public List<NoticeData> list;

    static {
        list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(new NoticeData(String.valueOf(i),"Test Title "+ i,"Test Body " + i,"Test Footer " + i));
        }
    }
}
