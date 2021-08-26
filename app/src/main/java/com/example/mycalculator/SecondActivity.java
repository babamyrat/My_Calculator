package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycalculator.domain.Counter;
import com.example.mycalculator.domain.SecondCounter;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity_Log2";
    private static final String ARG_COUNTER_VALUE = "ARG_COUNTER_VALUE";
    private static final String ARG_SECOND_COUNTER_VALUE = "ARG_SECOND_COUNTER_VALUE";
    private static final String ARG_THIRD_COUNTER_VALUE = "ARG_THIRD_COUNTER_VALUE";
    private final View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    private int firstCounterValue = 0;
    private TextView firstCounterResult;
    private TextView secondCounterResult;
    private TextView thirdCounterResult;
    private Counter counter;
    private SecondCounter secondCounter;

    // NEVER DO THIS
//    private static SecondActivity instance ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // NEVER DO THIS

//        instance = this;

        getIntent().getIntExtra("key", 0);


        if (savedInstanceState == null) {
            log("Fresh Create");

            counter = new Counter();
            secondCounter = new SecondCounter();

        } else {
            log("Rereate");
            firstCounterValue = savedInstanceState.getInt(ARG_COUNTER_VALUE);

            counter = (Counter) savedInstanceState.getSerializable(ARG_SECOND_COUNTER_VALUE);
            secondCounter = savedInstanceState.getParcelable(ARG_THIRD_COUNTER_VALUE);
        }

        firstCounterResult = findViewById(R.id.first_counter_result);

        secondCounterResult = findViewById(R.id.second_counter_result);

        thirdCounterResult = findViewById(R.id.third_counter_result);

        updateCounter();

        updateSecondCounter();

        updateThirdCounter();

        findViewById(R.id.btn_increase_count).setOnClickListener(v -> {
            firstCounterValue++;
            updateCounter();
        });

        findViewById(R.id.btn_second_increase_count).setOnClickListener(v -> {
            counter.increase();
            updateSecondCounter();
        });

        findViewById(R.id.btn_third_increase_count).setOnClickListener(v -> {
            secondCounter.increase();
            updateThirdCounter();
        });


//        findViewById(R.id.btn_increase_count).setOnClickListener(new ClickHandler());
//        findViewById(R.id.btn_increase_count).setOnClickListener(clickListener);
//        findViewById(R.id.btn_increase_count).setOnClickListener(this);

//        finish();
//
//        onBackPressed();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_increase_count) {

        }

        switch (v.getId()) {
            case R.id.btn_increase_count:

                break;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        log("Started");
    }

    @Override
    protected void onResume() {
        super.onResume();

        log("Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();

        log("Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();

        log("Stopped");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        log("Save instance state");

        outState.putInt(ARG_COUNTER_VALUE, firstCounterValue);
        outState.putSerializable(ARG_SECOND_COUNTER_VALUE, counter);
        outState.putParcelable(ARG_THIRD_COUNTER_VALUE, secondCounter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        log("Destroyed");
    }

    private void updateCounter() {
        firstCounterResult.setText(String.valueOf(firstCounterValue));
    }

    private void updateSecondCounter() {
        secondCounterResult.setText(String.valueOf(counter.getValue()));
    }

    private void updateThirdCounter() {
        thirdCounterResult.setText(String.valueOf(secondCounter.getValue()));
    }

    private void log(String message) {
        Log.d(TAG, message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    static class ClickHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }

}