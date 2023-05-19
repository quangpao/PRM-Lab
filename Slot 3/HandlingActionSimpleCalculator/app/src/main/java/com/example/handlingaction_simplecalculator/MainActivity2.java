package com.example.handlingaction_simplecalculator;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    public EditText editText1;
    public EditText editText2;
    public Button addBtn;
    public Button subBtn;
    public Button mulBtn;
    public Button divBtn;
    public TextView result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText1 = findViewById(R.id.firstNumber2);
        editText2 = findViewById(R.id.secondNumber2);
        addBtn = findViewById(R.id.addButton2);
        subBtn = findViewById(R.id.subtractButton2);
        mulBtn = findViewById(R.id.multiplyButton2);
        divBtn = findViewById(R.id.divideButton2);
        result = findViewById(R.id.resultNumber2);

        addBtn.setOnClickListener(view -> {
            if (editText1.getText().toString().equals("") || editText2.getText().toString().equals("")){
                result.setText("Please enter a number");
                return;
            }
            result.setText(String.valueOf(onCalculate('+', Double.parseDouble(editText1.getText().toString()), Double.parseDouble(editText2.getText().toString()))));
        });
        subBtn.setOnClickListener(view -> {
            if (editText1.getText().toString().equals("") || editText2.getText().toString().equals("")){
                result.setText("Please enter a number");
                return;
            }
            result.setText(String.valueOf(onCalculate('-', Double.parseDouble(editText1.getText().toString()), Double.parseDouble(editText2.getText().toString()))));

        });
        mulBtn.setOnClickListener(view -> {
            if (editText1.getText().toString().equals("") || editText2.getText().toString().equals("")){
                result.setText("Please enter a number");
                return;
            }
            result.setText(String.valueOf(onCalculate('*', Double.parseDouble(editText1.getText().toString()), Double.parseDouble(editText2.getText().toString()))));
        });
        divBtn.setOnClickListener(view -> {
            if (editText1.getText().toString().equals("") || editText2.getText().toString().equals("")){
                result.setText("Please enter a number");
                return;
            }
            if (Double.parseDouble(editText2.getText().toString()) == 0){
                result.setText("Cannot divide by zero");
                return;
            }
            result.setText(String.valueOf(onCalculate('/', Double.parseDouble(editText1.getText().toString()), Double.parseDouble(editText2.getText().toString()))));
        });
    }

    private double onCalculate(char method, double num1, double num2) {
        switch (method) {
            case '+': {
                return num1 + num2;
            }
            case '-': {
                return num1 - num2;
            }
            case '*': {
                return num1 * num2;
            }
            case '/': {
                return num1 / num2;
            }
        }
        return -1;
    }
}
