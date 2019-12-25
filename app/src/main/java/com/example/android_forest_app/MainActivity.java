package com.example.android_forest_app;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_forest_app.view.ChooseDialog;
import com.example.android_forest_app.view.processBar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {
    private TextView mCoinSum;
    private DrawerLayout mDrawerLayout;
    private NavigationView mLeftMenu;
    private ImageView mLeftMenuButton;
    private processBar mProcessBar;
    private Button mStartButton;
    private Button mCancelButton;

    private ImageView mBase;
    private ImageView mTree;
    private ChooseDialog mChooseDialog;
    private String choose;
    private int progress;
    private int minute;
    private int second;

    private static boolean flagLock;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choose = "starBurst";

        mCoinSum = findViewById(R.id.coinSum);
        mDrawerLayout = findViewById(R.id.drawlayout);
        mLeftMenu = findViewById(R.id.leftMenu);
        mLeftMenuButton = findViewById(R.id.leftMenuButton);
        mProcessBar = findViewById(R.id.processBar);
        mStartButton = findViewById(R.id.startButton);
        mCancelButton = findViewById(R.id.cancelButton);
        mBase = findViewById(R.id.base);
        mTree = findViewById(R.id.tree);

        flagLock = mProcessBar.getflagLock();
        if(flagLock){
            mCancelButton.setVisibility(View.VISIBLE);
            mStartButton.setVisibility(View.GONE);
        }
        else{
            mCancelButton.setVisibility(View.GONE);
            mStartButton.setVisibility(View.VISIBLE);
        }
        initListener();
    }

    private void initListener(){
        mBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mChooseDialog = new ChooseDialog(MainActivity.this);
                mChooseDialog.setStarBurstOnClickListener(new ChooseDialog.starBurstOnClickListener() {
                    @Override
                    public void onClick() {
                        choose = "starBurst";
                        mChooseDialog.dismiss();
                        update("starBurst");
                    }
                });
                mChooseDialog.setTimeOnClickListener(new ChooseDialog.timeOnClickListener() {
                    @Override
                    public void onClick() {
                        choose = "time";
                        mChooseDialog.dismiss();
                        update("time");
                    }
                });
                mChooseDialog.setStarClickListener(new ChooseDialog.starOnClickListener() {
                    @Override
                    public void onClick() {
                        choose = "star";
                        mChooseDialog.dismiss();
                        update("star");
                    }
                });
                mChooseDialog.show();
            }
        });
        mProcessBar.setProgressCallback(new processBar.progressCallback() {
            @Override
            public void updateListener(int _progress) {
                progress = _progress;
                update(choose);
            }
        });

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagLock = true;
                mProcessBar.setflagLock(flagLock);
                mProcessBar.invalidate();
                mCancelButton.setVisibility(View.VISIBLE);
                mStartButton.setVisibility(View.GONE);
            }
        });
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagLock = false;
                mProcessBar.setflagLock(flagLock);
                mProcessBar.invalidate();
                mCancelButton.setVisibility(View.GONE);
                mStartButton.setVisibility(View.VISIBLE);
            }
        });

        mLeftMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        mLeftMenu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.menu_forest:
                        break;
                    case R.id.menu_timeline:
                        break;
                    case R.id.menu_tag:
                        break;
                    case R.id.menu_store:
                        break;
                    case R.id.menu_setting:
                        break;
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void update(String treeName){
        int level;
        int minute = progress/60;
        if(minute<60)
            level = 4;
        else if(minute<90)
            level = 5;
        else if(minute<120)
            level = 6;
        else
            level = 7;
        treeName = treeName + level;
        switch(treeName){
            case "starBurst1": mTree.setImageResource(R.drawable.starburst1); break;
            case "starBurst2": mTree.setImageResource(R.drawable.starburst2); break;
            case "starBurst3": mTree.setImageResource(R.drawable.starburst3); break;
            case "starBurst4": mTree.setImageResource(R.drawable.starburst4); break;
            case "starBurst5": mTree.setImageResource(R.drawable.starburst5); break;
            case "starBurst6": mTree.setImageResource(R.drawable.starburst6); break;
            case "starBurst7": mTree.setImageResource(R.drawable.starburst7); break;
            case "time1": mTree.setImageResource(R.drawable.time1); break;
            case "time2": mTree.setImageResource(R.drawable.time2); break;
            case "time3": mTree.setImageResource(R.drawable.time3); break;
            case "time4": mTree.setImageResource(R.drawable.time4); break;
            case "time5": mTree.setImageResource(R.drawable.time5); break;
            case "time6": mTree.setImageResource(R.drawable.time6); break;
            case "time7": mTree.setImageResource(R.drawable.time7); break;
            case "star1": mTree.setImageResource(R.drawable.star1); break;
            case "star2": mTree.setImageResource(R.drawable.star2); break;
            case "star3": mTree.setImageResource(R.drawable.star3); break;
            case "star4": mTree.setImageResource(R.drawable.star4); break;
            case "star5": mTree.setImageResource(R.drawable.star5); break;
            case "star6": mTree.setImageResource(R.drawable.star6); break;
            case "star7": mTree.setImageResource(R.drawable.star7); break;
        }
    }
}
