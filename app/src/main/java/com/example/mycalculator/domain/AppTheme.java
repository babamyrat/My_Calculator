package com.example.mycalculator.domain;

import com.example.mycalculator.R;

public enum AppTheme {

    BLACK(R.style.CalcTheme, "black"),
    RED(R.style.CalcThemeRed, "red");

    private final int theme;
    private final String key;

    AppTheme(int value, String key) {
        this.theme = value;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public int getTheme() {
        return theme;
    }
}