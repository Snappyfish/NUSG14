package com.nusg.app.student;


import com.nusg.app.R;
import com.nusg.app.R.id;
import com.nusg.app.R.layout;
import com.nusg.app.R.menu;
import com.nusg.app.startup.MainMenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class Student extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_main);
		
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
		Intent returnHome = new Intent(this, MainMenu.class);
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