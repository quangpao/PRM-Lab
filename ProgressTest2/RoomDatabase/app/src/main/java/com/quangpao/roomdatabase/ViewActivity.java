package com.quangpao.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {
    private ArrayList<Product> products;
    private ProductRVAdapter adapter;
    private RecyclerView rvProducts;
    ProductRepository res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        // getting data
        res = new ProductRepository(getApplication());
        products = new ArrayList<Product>();
        List<Product> data = res.getAll();
        for (int i = 0; i < data.size(); i++) {
            String name = data.get(i).getProductName();
            String des = data.get(i).getProductDescription();
            String dur = data.get(i).getProductPrice();
            products.add(new Product(name, des, dur));
        }
        //Passing array list to our adapter class
        adapter = new ProductRVAdapter(products,
                ViewActivity.this);
        //Creating recycler view
        rvProducts = findViewById(R.id.rvProducts);
        LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(ViewActivity.this, RecyclerView.VERTICAL,
                false);
        rvProducts.setLayoutManager(linearLayoutManager);
        rvProducts.setAdapter(adapter);//Setting our adapter to recycler view
    }
}