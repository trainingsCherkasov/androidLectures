package com.example.illya.studyapplecture11.activities;


import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.illya.studyapplecture11.R;

public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings);
    }
}
