package com.nusg.app.essentials;

import android.os.Bundle;
import android.app.Activity;
//import android.view.Menu;
import android.view.View;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import com.nusg.app.R;

public class Essentials extends Activity {

	private final LatLng LOCATION_NEWCASTLE = new LatLng (54.982533, -1.626309);
	private final LatLng LOCATION_UNIVERSITY = new LatLng (54.982964, -1.625451);
	private GoogleMap map;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.google_maps);
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.google_map)).getMap();
		map.addMarker(new MarkerOptions().position(LOCATION_NEWCASTLE));
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
	
	public void onClick_newcastle(View view){
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_NEWCASTLE,15);
		map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		map.animateCamera(update);
	}
	
	public void onClick_university(View view){
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_UNIVERSITY,15);
		map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		map.animateCamera(update);
	}

}
