package com.example.intentex;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView tvShow;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvShow = findViewById(R.id.tvShow);

        if(getIntent() != null) {
            String data = getIntent().getStringExtra("MESSAGE");
            tvShow.setText("Hello " + data);
        }
    }
}
