package com.example.bplist;

import java.util.ArrayList;
import java.util.List;

public class BPLab {
    private static BPLab sPBLab;

    private List<BloodPressure> mReadings;

    public static BPLab get()
    {
        if(sPBLab == null) {
            sPBLab = new BPLab();
        }
        return sPBLab;
    }

    private BPLab() {
        mReadings = new ArrayList<>();
    }

    public List<BloodPressure> getReadings() { return mReadings; }
}
