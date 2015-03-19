package com.example.simchange;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class simset extends PreferenceActivity {
	
	 SharedPreferences prefs;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
	}

}
