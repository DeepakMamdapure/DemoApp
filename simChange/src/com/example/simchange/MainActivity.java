package com.example.simchange;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MainActivity  extends PreferenceActivity {
	/** Called when the activity is first created. */
	EditTextPreference serialNo,number1,number2,number3;
	TelephonyManager tManager;
	String simSerialNumber,deviceno;
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		addPreferencesFromResource(R.xml.preferences);
		prefs = PreferenceManager.getDefaultSharedPreferences(this);

		 serialNo = (EditTextPreference) findPreference("keyword");
		 number1 = (EditTextPreference) findPreference("number1");
		 number2 = (EditTextPreference) findPreference("number2");
          number3 = (EditTextPreference) findPreference("number3");
		
		 tManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		 simSerialNumber = tManager.getSimSerialNumber();
		 deviceno = tManager.getDeviceId();
		 Log.e("sim no", ""+simSerialNumber);
		 
		serialNo.setText(simSerialNumber);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString(SERIAL_NUMBER, simSerialNumber);
		editor.putString("NUMBER1", number1+"");
		editor.putString("NUMBER2", number2+"");
		editor.putString("NUMBER3", number3+"");

		editor.commit();
		/*Intent i = new Intent(this, home.class);
		startActivity(i);*/
	}

	private SharedPreferences prefs;
	public static final String SERIAL_NUMBER = "serial_number";
	public static final String NUMBER1 = "number1";
	public static final String NUMBER2 = "number2";
	public static final String NUMBER3 = "number3";
}
