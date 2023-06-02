package com.example.recyclerproductlab2;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<String> mData;

    private LayoutInflater mInflater;

    private ItemClickListener mClickListener;

    MyRecyclerViewAdapter(Context context, List<String> data, List<String> imageLink) {
        this.mData =data;
        this.mInflater = LayoutInflater.from(context);

    }

}
