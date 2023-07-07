package com.quangpao.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtProductName, edtProductDescription,
            edtProductPrice;
    private Button btnAddProduct, btnReadProducts;
    ProductRepository res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initializing all our variables
        edtProductName = findViewById(R.id.edtName);
        edtProductDescription =
                findViewById(R.id.edtDescription);
        edtProductPrice = findViewById(R.id.edtPrice);
        btnAddProduct = findViewById(R.id.btnAddProduct);
        btnReadProducts = findViewById(R.id.btnReadProducts);
        res = new ProductRepository(getApplication());
        btnAddProduct.setOnClickListener(v -> addProduct());
        btnReadProducts.setOnClickListener(v -> {
            //Opening ViewProducts activity via a intent
            Intent i = new Intent(MainActivity.this,
                    ViewActivity.class);
            startActivity(i);
        });
    }
    public void addProduct()
    {
        Product course = new Product(edtProductName.getText().toString(),edtProductDescription.getText().toString(),edtProductPrice.getText().toString());
        res.insert(course);
        Toast.makeText(MainActivity.this, "Product has been added.", Toast.LENGTH_SHORT).show();
        edtProductName.setText("");
        edtProductDescription.setText("");
        edtProductPrice.setText("");
    }
}