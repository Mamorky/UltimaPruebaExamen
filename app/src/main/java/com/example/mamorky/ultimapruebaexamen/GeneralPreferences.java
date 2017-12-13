package com.example.mamorky.ultimapruebaexamen;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;

/**
 * Created by mamorky on 13/12/17.
 */

public class GeneralPreferences extends PreferenceActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences_general);
    }
}
