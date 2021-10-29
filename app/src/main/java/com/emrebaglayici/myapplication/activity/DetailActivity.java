package com.emrebaglayici.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.emrebaglayici.myapplication.R;
import com.emrebaglayici.myapplication.fragments.DetailFragment;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.detail, new DetailFragment()).addToBackStack(null).commit();
        }

    }
}