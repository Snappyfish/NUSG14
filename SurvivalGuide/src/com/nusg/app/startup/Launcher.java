package com.nusg.app.startup;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Launcher extends Activity{

//	@SuppressLint("InlinedApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
	    getActionBar().hide();
	    if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
        	View decorView = getWindow().getDecorView();
        	// Hide the status bar.
        	int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN; 
        	//This lint warning can be ignored as the if statement above means only android builds past 16 will run this code.
        	decorView.setSystemUiVisibility(uiOptions);
        }

		setContentView(com.nusg.app.R.layout.loadingscreen);
		
		
		
		Thread timer = new Thread(){
			
			public void run(){
				try{
					sleep(1500);
				}
				catch(InterruptedException e){
					System.out.println("Timer is not running properly.");
					e.printStackTrace();
				}
				finally{
					Intent openMain = new Intent ("com.nusg.app.MainMenu");
					startActivity(openMain);
					finish();
				}
			}
		};
		timer.start();
	}
	
	@Override
	public void onConfigurationChanged(Configuration config) {
	  super.onConfigurationChanged(config);
	}
	
}
