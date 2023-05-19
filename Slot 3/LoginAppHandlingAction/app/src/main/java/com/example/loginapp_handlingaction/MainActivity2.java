package com.example.loginapp_handlingaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    public Button myButton1;
    public EditText myUser1;
    public EditText myPass1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myButton1 = findViewById(R.id.btnOk1);
        myUser1 = findViewById(R.id.editUser1);
        myPass1 = findViewById(R.id.editPassword1);
        myButton1.setOnClickListener(view -> {
            if(myUser1.getText().toString().equals("admin2") && myPass1.getText().toString().equals("12345")) {
                Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
