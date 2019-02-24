package com.example.bplist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView mReadingsList;
    private LinearLayoutManager mLinearLayoutManager;
    private AppAdapter mAppAdapter;

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.add_item:
                Random random = new Random();
                int systolic = 100 + random.nextInt(50);
                int diastolic = 60 + random.nextInt(40);
                BloodPressure bp = new BloodPressure(systolic,diastolic, new Date());
                BPLab.get().getReadings().add(bp);
                mAppAdapter.notifyItemInserted(BPLab.get().getReadings().size() - 1);
                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);

        mReadingsList = findViewById(R.id.readings_list);
        mReadingsList.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mReadingsList.setLayoutManager(mLinearLayoutManager);
        mAppAdapter = new AppAdapter(BPLab.get().getReadings());
        mReadingsList.setAdapter(mAppAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


}
