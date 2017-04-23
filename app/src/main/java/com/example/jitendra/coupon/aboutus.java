package com.example.jitendra.coupon;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getActionBar();
        try {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);

        } catch (NullPointerException e) {
            System.out.print("Caught the NullPointerException");
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
    }
}
