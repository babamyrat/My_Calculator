package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.mycalculator.domain.AppTheme;
import com.example.mycalculator.storage.ThemeStorage;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private float mValueOne;
    private float mValueTwo;
    private boolean aBooleanDivide;
    private boolean aBooleanMultiplication;
    private boolean aBooleanMinus;
    private boolean aBooleanPlus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ThemeStorage storage = new ThemeStorage(this);
        setTheme(storage.getAppTheme().getTheme());

        setContentView(R.layout.activity_main);


        Button key1 = findViewById(R.id.key_1);
        Button key2 = findViewById(R.id.key_2);
        Button key3 = findViewById(R.id.key_3);
        Button key4 = findViewById(R.id.key_4);
        Button key5 = findViewById(R.id.key_5);
        Button key6 = findViewById(R.id.key_6);
        Button key7 = findViewById(R.id.key_7);
        Button key8 = findViewById(R.id.key_8);
        Button key9 = findViewById(R.id.key_9);
        Button keyDivide = findViewById(R.id.key_del);
        Button keyMultiplication = findViewById(R.id.key_pul);
        Button keyMinus = findViewById(R.id.key_minus);
        Button keyDot = findViewById(R.id.key_dot);
        Button keyEquals = findViewById(R.id.key_equals);
        Button keyPlus = findViewById(R.id.key_plus);
        Button btnClear = findViewById(R.id.btnClear);
        editText = findViewById(R.id.editTextNumber);
        Button btnSetting = findViewById(R.id.btnSetting);
        Button btnSetting2 = findViewById(R.id.btnSetting2);

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storage.setAppTheme(AppTheme.BLACK);
                recreate();

            }
        });


        btnSetting2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storage.setAppTheme(AppTheme.RED);
                recreate();

            }

        });


        key1.setOnClickListener(view -> {
            editText.setText(editText.getText() + "1");
        });
        key2.setOnClickListener(view -> {
            editText.setText(editText.getText() + "2");
        });
        key3.setOnClickListener(view ->
                editText.setText(editText.getText() + "3")
        );
        key4.setOnClickListener(view ->
                editText.setText(editText.getText() + "4")
        );
        key5.setOnClickListener(view ->
                editText.setText(editText.getText() + "5")
        );
        key6.setOnClickListener(view ->
                editText.setText(editText.getText() + "6")
        );
        key7.setOnClickListener(view ->
                editText.setText(editText.getText() + "7")
        );
        key8.setOnClickListener(view ->
                editText.setText(editText.getText() + "8")
        );
        key9.setOnClickListener(view ->
                editText.setText(editText.getText() + "9")
        );

        keyDot.setOnClickListener(view ->
                editText.setText(editText.getText() + ".")
        );

        //Plus
        keyPlus.setOnClickListener(view ->{

            if (editText == null) {
                editText.setText("");
            } else {
                mValueOne = Float.parseFloat(editText.getText() + "");
                aBooleanPlus = true;
                editText.setText(null);
            }

        });

        //Minus
        keyMinus.setOnClickListener(view ->{
            if (editText == null) {
                editText.setText("");
            } else {
                //first number
                mValueOne = Float.parseFloat(editText.getText() + "");
                aBooleanMinus = true;
                editText.setText(null);
            }
        });


        // * Multiplication
        keyMultiplication.setOnClickListener(view -> {
            if (editText == null) {
                editText.setText("");
            } else {
                //first number
                mValueOne = Float.parseFloat(editText.getText() + "");
                aBooleanMultiplication = true;
                editText.setText(null);
            }
        });

        // / Divide
        keyDivide.setOnClickListener(view -> {
        if (editText == null) {
            editText.setText("");
        } else {
            //first number
            mValueOne = Float.parseFloat(editText.getText() + "");
            aBooleanDivide = true;
            editText.setText(null);
        }
      });


        //Equals
        keyEquals.setOnClickListener(view ->{
            // Second number
            mValueTwo = Float.parseFloat(editText.getText() + "");

            //Plus
            if (aBooleanPlus == true) {
                editText.setText(mValueOne + mValueTwo + "");
                aBooleanPlus = false;
            }

            //Minus
            if (aBooleanMinus == true) {
                editText.setText(mValueOne - mValueTwo + "");
                aBooleanMinus = false;
            }

            //Multiplication
            if (aBooleanMultiplication == true) {
                editText.setText(mValueOne * mValueTwo + "");
                aBooleanMultiplication = false;
            }

            //Divide
            if (aBooleanDivide == true) {
                editText.setText(mValueOne / mValueTwo + "");
                aBooleanDivide = false;
            }

        });

        //Clear
        btnClear.setOnClickListener(view -> {
            editText.setText(" ");
        });

    }
}
