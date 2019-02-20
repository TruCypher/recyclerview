package com.example.bplist;

import java.util.Date;

/**
 * Created by pfgarofa on 2/5/2018.
 *
 * Source: http://www.merckmanuals.com/home/heart-and-blood-vessel-disorders/high-blood-pressure/high-blood-pressure#v718040
 */

public class BloodPressure {

    /*

    mCategories and mRecommendations are parallel arrays
    TODO: make these strings resources

    */
    private static final String mCategories[] = {
            "Low reading; reevaluate",
            "Normal blood pressure",
            "Elevated blood pressure",  // formerly "prehypertension"
            "Stage 1 hypertension",
            "Stage 2 hypertension"
    };

    private static final String mRecommendations[] = {
            "Take blood pressure reading again.",
            "Normal blood pressure, no treatment needed.",
            "Lifestyle changes. Reexamine in 3-6 months.",
            "Low-risk of ASCVD: Lifestyle changes; Reexamine in 3-6 months. Otherwise, treatment with 1 blood pressure lowering drug; reexamine in 1 month.",
            "Treatment with 2 blood pressure-lowering drugs. Reexamine in one month."
    };

    private int bp() {

        if (mSystolic < 100 || mDiastolic < 60)
            return 0;   // "Low reading; reevaluate";
        else if (mSystolic < 120 && mDiastolic < 80)
            return 1;   // "Normal blood pressure";
        else if (mSystolic < 130 && mDiastolic < 80)
            return 2;   // "Elevated blood pressure";
        else if (mSystolic < 140 && mDiastolic < 90)
            return 3;   // "Stage 1 hypertension";
        else
            return 4;   // "Stage 2 hypertension":
    }

    private int mSystolic, mDiastolic, mCategory;
    private Date mDate;

    BloodPressure(int systolic, int diastolic, Date date) {
        mSystolic = systolic;
        mDiastolic = diastolic;
        mDate = date;
        mCategory = bp();
    }

    public String getCategory() {
        return mCategories[mCategory];
    }

    public String getRecommendation() {
        return mRecommendations[mCategory];
    }

    public int getSystolic() {
        return mSystolic;
    }

    public void setSystolic(int systolic) {
        mSystolic = systolic;
        mCategory = bp();
    }

    public int getDiastolic() {
        return mDiastolic;
    }

    public void setDiastolic(int diastolic) {
        mDiastolic = diastolic;
        mCategory = bp();
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
