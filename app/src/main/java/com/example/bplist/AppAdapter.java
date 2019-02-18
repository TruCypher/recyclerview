package com.example.bplist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppViewHolder> {

    private List<BloodPressure> mReadings;

    public AppAdapter(List<BloodPressure> readings) {
        mReadings = readings;
    }
    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder appViewHolder, int i ) {

    }

    @Override
    public int getItemCount() {
        return mReadings.size();
    }

    public static class AppViewHolder extends RecyclerView.ViewHolder {

        public AppViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
