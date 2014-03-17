package com.nusg.app.startup;

import com.nusg.app.R;
import com.nusg.app.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class Launcher extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
	    getActionBar().hide();
		
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
				}
			}
		};
		timer.start();
	}
}
