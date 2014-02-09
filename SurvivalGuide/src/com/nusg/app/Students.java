package com.nusg.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

@SuppressLint("NewApi")
public class Students extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.students);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(com.nusg.app.R.menu.actionbar,menu);
		return true;
	}

	
	public boolean onOptionItemSelected (MenuItem item){
		super.onOptionsItemSelected(item);
		
		switch(item.getItemId()){
		
		case com.nusg.app.R.id.actionBarHome:
		Intent returnHome = new Intent(this, MainActivity.class);
		startActivity(returnHome);
		break;
		
		case com.nusg.app.R.id.settings:
		settingsMenuItem();
		break;
		
		case com.nusg.app.R.id.settings2:
		settings2MenuItem();
		break;
		
		case com.nusg.app.R.id.settings3:
		settings2MenuItem();
		break;
		
		case com.nusg.app.R.id.settings4:
		settings2MenuItem();
		break;
		}
		return true;
	}
	
	private void settingsMenuItem(){
		Toast.makeText(this,"hahahah",Toast.LENGTH_SHORT).show();
	}
	private void settings2MenuItem(){
		
	}
	private void settings3MenuItem(){
		
	}
	private void settings4MenuItem(){
	
	}
}