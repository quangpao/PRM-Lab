package com.example.intentex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText editTextName;
    public EditText editTextURL;
    public Button btnClickMe;
    public Button btnDial;
    public Button btnURL;
    public static final String EXTRA_MESSAGE = "com.example.intentex.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextURL = findViewById(R.id.editTextURL);
        btnClickMe = findViewById(R.id.buttonClickMe);
        btnDial = findViewById(R.id.buttonDial);
        btnURL = findViewById(R.id.buttonURL);
        btnClickMe.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            String yName = editTextName.getText().toString();
            intent.putExtra("MESSAGE", yName);
            startActivity(intent);
        });

        btnDial.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            startActivity(intent);
        });

        btnURL.setOnClickListener(view -> {
            String url = editTextURL.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
    }
}