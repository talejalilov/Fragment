package com.emrebaglayici.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.emrebaglayici.myapplication.fragments.FragmentItem;
import com.emrebaglayici.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState ==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentItem()).commit();
        }

    }
}