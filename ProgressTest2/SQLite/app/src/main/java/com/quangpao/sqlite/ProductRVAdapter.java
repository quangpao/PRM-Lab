package com.quangpao.sqlite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductRVAdapter extends RecyclerView.Adapter<ProductRVAdapter.ViewHolder> {

    private ArrayList<ProductModal> productModalArrayList;
    private Context context;

    public ProductRVAdapter(ArrayList<ProductModal> productModalArrayList, Context context) {
        this.productModalArrayList = productModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_rv_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductModal modal = productModalArrayList.get(position);
        holder.productName.setText(modal.getName());
        holder.productDescription.setText(modal.getDescription());
        holder.productPrice.setText(modal.getPrice());

        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, UpdateProduct.class);
            i.putExtra("name", modal.getName());
            i.putExtra("description", modal.getDescription());
            i.putExtra("price", modal.getPrice());

            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return productModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView productName, productDescription, productPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.idTVProductName);
            productDescription = itemView.findViewById(R.id.idTVProductDescription);
            productPrice = itemView.findViewById(R.id.idTVProductPrice);
        }
    }

}
