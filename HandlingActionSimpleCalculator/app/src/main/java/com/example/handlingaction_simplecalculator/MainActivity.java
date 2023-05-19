package com.example.handlingaction_simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText editText1;
    public EditText editText2;
    public TextView result;
    public Button addBtn;
    public Button subBtn;
    public Button mulBtn;
    public Button divBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.firstNumber);
        editText2 = findViewById(R.id.secondNumber);
        addBtn = findViewById(R.id.addButton);
        subBtn = findViewById(R.id.subtractButton);
        mulBtn = findViewById(R.id.multiplyButton);
        divBtn = findViewById(R.id.divideButton);
        result = findViewById(R.id.resultNumber);
    }

    public void onAdd(View view) {
        if (editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
            result.setText("Please enter a number");
        } else {
            double firstNumber = Double.parseDouble(editText1.getText().toString());
            double secondNumber = Double.parseDouble(editText2.getText().toString());
            double resultNumber = firstNumber + secondNumber;
            result.setText(String.valueOf(resultNumber));
        }
    }

    public void onSubtract(View view) {
        if (editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
            result.setText("Please enter a number");
        } else {
            double firstNumber = Double.parseDouble(editText1.getText().toString());
            double secondNumber = Double.parseDouble(editText2.getText().toString());
            double resultNumber = firstNumber - secondNumber;
            result.setText(String.valueOf(resultNumber));
        }
    }

    public void onMultiply(View view) {
        if (editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
            result.setText("Please enter a number");
        } else {
            double firstNumber = Double.parseDouble(editText1.getText().toString());
            double secondNumber = Double.parseDouble(editText2.getText().toString());
            double resultNumber = firstNumber * secondNumber;
            result.setText(String.valueOf(resultNumber));
        }
    }

    public void onDivide(View view) {
        if (editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
            result.setText("Please enter a number");
        } else {
            double firstNumber = Double.parseDouble(editText1.getText().toString());
            double secondNumber = Double.parseDouble(editText2.getText().toString());
            double resultNumber = firstNumber / secondNumber;
            result.setText(String.valueOf(resultNumber));
        }
    }


}