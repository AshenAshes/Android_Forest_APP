package com.example.android_forest_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TreeDeadActivity extends AppCompatActivity {
    private int coinNum;
    private TextView coinSum;
    private ImageView backButton;
    private ImageView tree;
    private String choose;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treedead);

        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        coinNum = preferences.getInt("coinSum",0);

        coinSum = findViewById(R.id.coinSum);
        coinSum.setText(coinNum+"");
        tree = findViewById(R.id.tree);
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        choose = intent.getStringExtra("choose");

        switch (choose){
            case "starBurst": tree.setImageResource(R.drawable.starburstdead); break;
            case "time": tree.setImageResource(R.drawable.timedead); break;
            case "star": tree.setImageResource(R.drawable.stardead); break;
        }

        Log.d("debug:","treeDead onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("debug:","treeDead onDestroyed");
    }
}
