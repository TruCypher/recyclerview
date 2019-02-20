package com.example.bplist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mGenerateBtn;
    private RecyclerView mReadingsList;
    private LinearLayoutManager mLinearLayoutManager;
    private AppAdapter mAppAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGenerateBtn = findViewById(R.id.generate_button);
        mGenerateBtn.setOnClickListener((v) -> {
            Random random = new Random();
            int systolic = 100 + random.nextInt(50);
            int diastolic = 60 + random.nextInt(40);
            BloodPressure bp = new BloodPressure(systolic,diastolic, new Date());
            BPLab.get().getReadings().add(bp);
            mAppAdapter.notifyItemInserted(BPLab.get().getReadings().size() - 1);
        });

        mReadingsList = findViewById(R.id.readings_list);
        mReadingsList.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mReadingsList.setLayoutManager(mLinearLayoutManager);
        mAppAdapter = new AppAdapter(BPLab.get().getReadings());
        mReadingsList.setAdapter(mAppAdapter);
    }
}
