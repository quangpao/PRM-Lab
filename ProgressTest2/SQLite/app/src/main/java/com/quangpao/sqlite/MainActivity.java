package com.quangpao.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText productNameEdt, productDescriptionEdt, productPriceEdt;
    private Button addProductBtn, readProductsBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productNameEdt = findViewById(R.id.idEdtProductName);
        productDescriptionEdt = findViewById(R.id.idEdtProductDescription);
        productPriceEdt = findViewById(R.id.idEdtProductPrice);
        addProductBtn = findViewById(R.id.idBtnAddProduct);
        readProductsBtn = findViewById(R.id.idBtnReadProducts);

        dbHandler = new DBHandler(MainActivity.this);

        addProductBtn.setOnClickListener(v -> {
            String productName = productNameEdt.getText().toString();
            String productDescription = productDescriptionEdt.getText().toString();
            String productPrice = productPriceEdt.getText().toString();

            if (productName.isEmpty() && productDescription.isEmpty() && productPrice.isEmpty()) {
                return;
            }
            dbHandler.addNewProduct(productName, productDescription, productPrice);
            Toast.makeText(MainActivity.this, "Product has been added", Toast.LENGTH_SHORT).show();
            productNameEdt.setText("");
            productDescriptionEdt.setText("");
            productPriceEdt.setText("");
        });

        readProductsBtn.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ViewProducts.class);
            startActivity(i);
        });
    }
}