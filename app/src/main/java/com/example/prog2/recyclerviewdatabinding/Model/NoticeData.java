package com.example.prog2.recyclerviewdatabinding.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.prog2.recyclerviewdatabinding.BR;

public class NoticeData extends BaseObservable{
    private String id;
    private String title;
    private String brief;
    private String fileSource;

    public NoticeData(String id, String title, String brief, String fileSource) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.fileSource = fileSource;
    }

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
        notifyPropertyChanged(BR.brief);
    }

    @Bindable
    public String getFileSource() {
        return fileSource;
    }

    public void setFileSource(String fileSource) {
        this.fileSource = fileSource;
        notifyPropertyChanged(BR.fileSource);
    }
}
