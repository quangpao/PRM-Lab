package com.quangpao.roomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductRVAdapter extends RecyclerView.Adapter<ProductRVAdapter.ViewHolder>{

    private ArrayList<Product> productsModalArrayList;
    private Context context;

    public ProductRVAdapter(ArrayList<Product>
                                    productsModalArrayList, Context context) {
        this.productsModalArrayList = productsModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int
            position) {
        // on below line we are setting data
        // to our views of recycler view item.
        Product modal = productsModalArrayList.get(position);
        holder.tvProductName.setText(modal.getProductName());
        holder.tvProductDesc.setText(modal.getProductDescription());
        holder.tvProductPrice.setText(modal.getProductPrice());
        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(v -> {
            //Update, delete
        });
    }
    @Override
    public int getItemCount() {
        // returning the size of our array list
        return productsModalArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvProductName, tvProductDesc,
                tvProductPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductDesc = itemView.findViewById(R.id.tvProductDescription);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
        }
    }

}
