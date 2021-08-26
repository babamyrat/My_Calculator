package com.example.mycalculator.domain;

import java.io.Serializable;

public class Counter implements Serializable {

    private int value;

    public int getValue() {
        return value;
    }

    public void increase() {
        value++;
    }
}
