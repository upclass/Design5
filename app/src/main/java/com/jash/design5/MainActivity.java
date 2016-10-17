package com.jash.design5;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CoordinatorLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewPager pager = (ViewPager) findViewById(R.id.main_pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.main_tab);
        tabLayout.setupWithViewPager(pager);
        layout = (CoordinatorLayout) findViewById(R.id.activity_main);
        findViewById(R.id.main_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(layout, "点击", Snackbar.LENGTH_LONG).show();
    }
}
