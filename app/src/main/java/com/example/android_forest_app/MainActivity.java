package com.example.android_forest_app;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView coinSum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coinSum = findViewById(R.id.coinSum);
        coinSum.setTextColor(Color.WHITE);
        Log.e("visibility",""+coinSum.getVisibility()+coinSum.getText());
    }
}
