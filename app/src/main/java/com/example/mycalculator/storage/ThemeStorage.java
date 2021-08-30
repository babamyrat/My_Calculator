package com.example.mycalculator.storage;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mycalculator.domain.AppTheme;

public class ThemeStorage {

    private static final String KEY_THEME = "KEY_THEME";

    private final Context context;

    private final SharedPreferences sharedPreferences;

    public ThemeStorage(Context context) {
        this.context = context;

        sharedPreferences = context.getSharedPreferences("Key_All", MODE_PRIVATE);

    }

    public AppTheme getAppTheme() {
        String value = sharedPreferences.getString(KEY_THEME, AppTheme.BLACK.getKey());

        for (AppTheme theme : AppTheme.values()) {
            if (theme.getKey().equals(value)) {
                return theme;
            }
        }

        return AppTheme.BLACK;

    }

    public void setAppTheme(AppTheme appTheme) {
        sharedPreferences.edit()
                .putString(KEY_THEME, appTheme.getKey())
                .apply();
    }
}
