package com.skyzone.netdemomvp.demo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.skyzone.netdemomvp.R;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        DemoFragment demoFragment = (DemoFragment) getSupportFragmentManager().findFragmentById(R.id.activity_demo_frame);

        if (null == demoFragment) {
            demoFragment = DemoFragment.newInstance();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.activity_demo_frame, demoFragment);
            transaction.commit();
        }

        new DemoPresenter(demoFragment);
    }
}
