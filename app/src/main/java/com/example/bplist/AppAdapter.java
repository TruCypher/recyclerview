package com.example.bplist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppViewHolder> {

    private List<BloodPressure> mReadings;

    public AppAdapter(List<BloodPressure> readings) {
        mReadings = readings;
    }
    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        AppViewHolder vh = new AppViewHolder(inflater,viewGroup);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder appViewHolder, int i ) {
        appViewHolder.bind(mReadings.get(i));
    }

    @Override
    public int getItemCount() {
        return mReadings.size();
    }

    public static class AppViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mReading, mDate;
        private BloodPressure mBloodPressure;

        public AppViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_layout, parent, false));

            itemView.setOnClickListener(this);
            mReading = itemView.findViewById(R.id.text_reading);
            mDate = itemView.findViewById(R.id.text_date);
        }

        public void bind(BloodPressure bloodPressure) {
            mBloodPressure = bloodPressure;
            mReading.setText(bloodPressure.getSystolic() + " / " + bloodPressure.getDiastolic() +
             " - " + bloodPressure.getCategory());

            mDate.setText(bloodPressure.getDate().toString());
        }

        @Override
        public void onClick(View v)
        {
            Toast.makeText(itemView.getContext(), "Clicked" + mBloodPressure.getCategory(), Toast.LENGTH_SHORT).show();
        }
    }
}
