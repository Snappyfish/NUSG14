package com.nusg.app.social;

import com.nusg.app.R;
import com.nusg.app.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;


public class Social extends Activity {

	int lastSelectedButton;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.social_main);
		
		View view = (View) findViewById(R.id.rootLayout);
		clickedButton1(view);
	}
	
	protected void onSaveInstanceState (Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putInt("selectedButton", lastSelectedButton);
		
	}
	
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		int lastSelected = savedInstanceState.getInt("selectedButton");
		
		View view = (View) findViewById(R.id.rootLayout);
		if(lastSelected == 0 | lastSelected == 1) {
			clickedButton1(view);
		} else if(lastSelected == 2) {
			clickedButton2(view);
		} else {
			clickedButton3(view);
		}
	}
	
	public void clickedButton1(View view) {
		//Setup the webView
		WebView webView = (WebView) findViewById(R.id.webView);
		webView.loadUrl("file:///android_asset/nightsOut.html");
		
		//Set the background image and underline on each button
		TextView currentButton = (TextView) findViewById(R.id.button1);
		currentButton.setBackgroundResource(R.drawable.button_selected);
		currentButton.setText(R.string.social_nightsU);
		
		currentButton = (TextView) findViewById(R.id.button2);
		currentButton.setText(R.string.social_deals);
		currentButton.setBackgroundResource(R.drawable.button_unselected);
		
		currentButton = (TextView) findViewById(R.id.button3);
		currentButton.setText(R.string.social_predrink);
		currentButton.setBackgroundResource(R.drawable.button_unselected);
		
		//Save the last selected button for activity lifecycle
		lastSelectedButton = 1;
	}
	
	public void clickedButton2(View view) {
		//Setup the webView
		WebView webView = (WebView) findViewById(R.id.webView);
		webView.loadUrl("file:///android_asset/travel.html");
		
		//Set the background image and underline on each button
		TextView currentButton = (TextView) findViewById(R.id.button1);
		currentButton.setBackgroundResource(R.drawable.button_unselected);
		currentButton.setText(R.string.social_nights);
		
		currentButton = (TextView) findViewById(R.id.button2);
		currentButton.setText(R.string.social_dealsU);
		currentButton.setBackgroundResource(R.drawable.button_selected);
		
		currentButton = (TextView) findViewById(R.id.button3);
		currentButton.setText(R.string.social_predrink);
		currentButton.setBackgroundResource(R.drawable.button_unselected);
		
		//Save the last selected button for activity lifecycle
		lastSelectedButton = 2;
	}
	
	public void clickedButton3(View view) {
		//Setup the webView
		WebView webView = (WebView) findViewById(R.id.webView);
		webView.loadUrl("file:///android_asset/clearing.html");
		
		//Set the background image and underline on each button
		TextView currentButton = (TextView) findViewById(R.id.button1);
		currentButton.setBackgroundResource(R.drawable.button_unselected);
		currentButton.setText(R.string.social_nights);
		
		currentButton = (TextView) findViewById(R.id.button2);
		currentButton.setText(R.string.social_deals);
		currentButton.setBackgroundResource(R.drawable.button_unselected);
		
		currentButton = (TextView) findViewById(R.id.button3);
		currentButton.setText(R.string.social_predrinkU);
		currentButton.setBackgroundResource(R.drawable.button_selected);
		
		
		//Save the last selected button for activity lifecycle
		lastSelectedButton = 3;
	}
	
}



/*package com.nusg.app;

import SideBar.SideBarListFragment;
import SideBar.SlideOutHelper;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

public class Social extends FragmentActivity {

	 private SlideOutHelper rSlideOutHelper;
		
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.social);
			rSlideOutHelper = new SlideOutHelper(this);
			rSlideOutHelper.activate();
			getSupportFragmentManager().beginTransaction().add(com.nusg.app.R.id.sidebar_content,new SideBarListFragment(),"menu").commit();
			rSlideOutHelper.open();
		}

			

		public boolean onKeyDown(int key, KeyEvent event){
			if(key==KeyEvent.KEYCODE_BACK){
				rSlideOutHelper.close();
				return true;
			}
			return super.onKeyDown(key, event);
			
		}
		
		public SlideOutHelper getSlideOutHelper(){
			return rSlideOutHelper;
		}
	*/
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.social);
		
		
		
//	}
//}
