package com.example.prog2.recyclerviewdatabinding.Adapter;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.prog2.recyclerviewdatabinding.BR;
import com.example.prog2.recyclerviewdatabinding.Interface.RecyclerItemClickListener;
import com.example.prog2.recyclerviewdatabinding.Model.NoticeData;
import com.example.prog2.recyclerviewdatabinding.R;

import java.util.ArrayList;
import java.util.List;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.EmployeeViewHolder>{

    private List<NoticeData> dataList;
    private RecyclerItemClickListener itemClickListener;

    public NoticeAdapter(ArrayList<NoticeData> dataList, RecyclerItemClickListener itemClickListener) {
        this.dataList = dataList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_row,parent,false);

        return new EmployeeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder,@SuppressLint("RecyclerView") final int position) {

        ViewDataBinding binding = holder.getViewDataBinding();
        binding.setVariable(BR.notice,dataList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(dataList.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding dataBinding;

        public EmployeeViewHolder(ViewDataBinding itemView) {
            super(itemView.getRoot());

            dataBinding = itemView;


            dataBinding.executePendingBindings();
        }

        public ViewDataBinding getViewDataBinding() {
            return dataBinding;
        }
    }
}
