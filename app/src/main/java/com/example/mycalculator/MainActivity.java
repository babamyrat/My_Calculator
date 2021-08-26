package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button key1, key2, key3, key4, key5, key6, key7, key8, key9, key_del, key_pul, key_minus, key_dot, key_equals, key_plus;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        key1 = findViewById(R.id.key_1);
        key2 = findViewById(R.id.key_2);
        key3 = findViewById(R.id.key_3);
        key4 = findViewById(R.id.key_4);
        key5 = findViewById(R.id.key_5);
        key6 = findViewById(R.id.key_6);
        key7 = findViewById(R.id.key_7);
        key8 = findViewById(R.id.key_8);
        key9 = findViewById(R.id.key_9);
        key_del = findViewById(R.id.key_del);
        key_pul = findViewById(R.id.key_pul);
        key_minus = findViewById(R.id.key_minus);
        key_dot = findViewById(R.id.key_dot);
        key_equals = findViewById(R.id.key_equals);
        key_plus = findViewById(R.id.key_plus);
        editText = findViewById(R.id.editTextNumber);


        key1.setOnClickListener(view -> editText.setText("1"));
        key2.setOnClickListener(view -> editText.setText("2"));
        key3.setOnClickListener(view -> editText.setText("3"));
        key4.setOnClickListener(view -> editText.setText("4"));
        key5.setOnClickListener(view -> editText.setText("5"));
        key6.setOnClickListener(view -> editText.setText("6"));
        key7.setOnClickListener(view -> editText.setText("7"));
        key8.setOnClickListener(view -> editText.setText("8"));
        key9.setOnClickListener(view -> editText.setText("9"));
        key_del.setOnClickListener(view -> editText.setText("/"));
        key_pul.setOnClickListener(view -> editText.setText("*"));
        key_dot.setOnClickListener(view -> editText.setText("."));
        key_minus.setOnClickListener(view -> editText.setText("-"));
        key_equals.setOnClickListener(view -> editText.setText("="));
        key_plus.setOnClickListener(view -> editText.setText("+"));

    }
}