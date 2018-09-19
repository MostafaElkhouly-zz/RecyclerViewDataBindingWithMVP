package com.example.prog2.recyclerviewdatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.prog2.recyclerviewdatabinding.Adapter.NoticeAdapter;
import com.example.prog2.recyclerviewdatabinding.Interface.RecyclerItemClickListener;
import com.example.prog2.recyclerviewdatabinding.Model.Notice;
import com.example.prog2.recyclerviewdatabinding.Model.NoticeData;
import com.example.prog2.recyclerviewdatabinding.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainContract.MainView{

    ActivityMainBinding binding;

    private ProgressBar progressBar;

    private MainContract.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        initializeToolbarAndRecyclerView();
        initProgressBar();

        presenter = new MainPresenter(this, new GetNoticeIntractorImpl());
        presenter.requestDataFromServer();

    }

    private RecyclerItemClickListener recyclerItemClickListener = new RecyclerItemClickListener() {
        @Override
        public void onItemClick(NoticeData notice) {
            Toast.makeText(MainActivity.this,
                    "List title:  " + notice.getTitle(),
                    Toast.LENGTH_LONG).show();
        }


    };


    private void initProgressBar() {
        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setGravity(Gravity.CENTER);
        relativeLayout.addView(progressBar);

        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        progressBar.setVisibility(View.INVISIBLE);

        this.addContentView(relativeLayout, params);
    }

    private void initializeToolbarAndRecyclerView() {

//        binding.

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        this.binding.recyclerViewEmployeeList.setLayoutManager(layoutManager);

    }

    @Override
    public void showProgress() {
        this.binding.recyclerViewEmployeeList.setVisibility(View.GONE);
        this.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        this.binding.recyclerViewEmployeeList.setVisibility(View.VISIBLE);
        this.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setDataToRecyclerView(ArrayList<NoticeData> noticeArrayList) {
        NoticeAdapter adapter = new NoticeAdapter(noticeArrayList , recyclerItemClickListener);
        this.binding.recyclerViewEmployeeList.setAdapter(adapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.presenter.onDestroy();
    }
}
