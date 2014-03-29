package com.example.test_lm;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class TestLM extends Activity {

	private static String tag = "test-lm";
	private LocationManager locationManager;
	ArrayList<Location> pb_buffer = new ArrayList<Location>();
	TextView t;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_lm);
		Log.i(tag, "test-lm");
		locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		LocationListener locationListener = new LocationListener() {
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
				Log.i(tag, "onLocationChanged:" + location.toString());
				t.setText(location.getProvider() + ":" + location.getAltitude() + ":" + location.getLatitude() + ":" + location.getLongitude());
				Location l = new Location("GPS");
				l.setAltitude(11);
				l.setLatitude(15);
				l.setLongitude(20);
				locationManager.setLocation(l);
			}
		};
		t = (TextView)findViewById(R.id.values);
		Log.i(tag, "Running test-lm2");
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
		pb_buffer.isEmpty();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_test_lm, menu);
		return true;
	}

}
