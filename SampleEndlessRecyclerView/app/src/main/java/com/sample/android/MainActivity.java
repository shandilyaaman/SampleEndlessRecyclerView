package com.sample.android;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.sample.android.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> mStringList;
    private int mLoadedItems = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        activityMainBinding.recyclerView.setLayoutManager(linearLayoutManager);
        activityMainBinding.recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
        mStringList = new ArrayList<>();
        addDataToList();
        SampleAdapter sampleAdapter = new SampleAdapter(mStringList);
        activityMainBinding.recyclerView.setAdapter(sampleAdapter);
    }

    private void addDataToList() {
        for (int i = 0; i <= 30; i++) {
            mStringList.add("SampleText : " + i);
            mLoadedItems++;
        }
    }
}
