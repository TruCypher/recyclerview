package com.example.bplist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Button mGenerateBtn;
    private RecyclerView mReadingsList;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGenerateBtn = findViewById(R.id.generate_button);
        mGenerateBtn.setOnClickListener((v) -> {

        });

        mReadingsList = findViewById(R.id.readings_list);
        mReadingsList.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mReadingsList.setLayoutManager(mLinearLayoutManager);
    }
}
