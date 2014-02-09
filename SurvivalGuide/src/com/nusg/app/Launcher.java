package com.nusg.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Launcher extends Activity{

	protected void onCreate(Bundle CallumIHateYou) {
		super.onCreate(CallumIHateYou);
		
		setContentView(com.nusg.app.R.layout.loadingscreen);
		Thread timer = new Thread(){
			
			public void run(){
				try{
					sleep(3000);
				}
				catch(InterruptedException e){
					System.out.println("Timer is not running properly.");
					e.printStackTrace();
				}
				finally{
					Intent openMain = new Intent ("com.nusg.app.MAINACTIVITY");
					startActivity(openMain);
				}
			}
		};
		timer.start();
	}
}
