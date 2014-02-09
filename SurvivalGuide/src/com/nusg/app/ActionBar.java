package com.nusg.app;

//Testing, just a git comment

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ActionBar extends Activity{
	
	@Override
	@SuppressLint("NewApi")
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//setContentView(com.nusg.app.R.layout.actionbar);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(com.nusg.app.R.menu.actionbar,menu);
		return super.onCreateOptionsMenu(menu);
	}

	
	public boolean onOptionItemSelect (MenuItem item){
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
		
	}
	private void settings2MenuItem(){
		
	}
	private void settings3MenuItem(){
		
	}
	private void settings4MenuItem(){
	
	}
	/*
	private void actionBarHomeMenuItem(){
		com.nusg.app.R.id.actionBarHome.setOnClickListener(new View.OnClickListener() {
		public void onClick(View arg){
			Intent returnHome = new Intent("com.nusg.app.MAINACTIVITY");
			startActivity(returnHome);
		}
	});
	}
	*/		
}
