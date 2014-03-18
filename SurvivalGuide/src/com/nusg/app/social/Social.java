package com.nusg.app.social;

import com.nusg.app.R;
import com.nusg.app.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Social extends Activity {

//	int lastSelectedButton = 1;
//	String selectedButton = "selectedButton";
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.social_main);
//		WebView webView = (WebView) findViewById(R.id.webView);
//		
//		if(savedInstanceState.getInt(selectedButton) == 0 | savedInstanceState.getInt(selectedButton) == 1) {
//			clickedButton1(webView);
//		} else if(savedInstanceState.getInt(selectedButton) == 2) {
//			clickedButton2(webView);
//		} else {
//			clickedButton3(webView);
//		}
		
		
		
	}
	
//	protected void onSaveInstanceState (Bundle savedInstanceState) {
//		savedInstanceState.putInt(selectedButton, lastSelectedButton);
//		
//		
//	}
	
	
	public void clickedButton1(View view) {
		//Setup the webView
		WebView webView = (WebView) findViewById(R.id.webView);
		webView.loadUrl("http://homepages.cs.ncl.ac.uk/2013-14/csc2022_team14/nightsOut.html");
		
		//Set the background image on each button
		LinearLayout buttoncont = (LinearLayout) findViewById(R.id.button1container);
		buttoncont.setBackgroundResource(R.drawable.button_selected);
		buttoncont = (LinearLayout) findViewById(R.id.button2container);
		buttoncont.setBackgroundResource(R.drawable.button_unselected);
		buttoncont = (LinearLayout) findViewById(R.id.button3container);
		buttoncont.setBackgroundResource(R.drawable.button_unselected);
		
		//Set the underline on selected button
		TextView textView = (TextView) findViewById(R.id.button1);
		textView.setText(R.string.social_nightsU);
		textView = (TextView) findViewById(R.id.button2);
		textView.setText(R.string.social_deals);
		textView = (TextView) findViewById(R.id.button3);
		textView.setText(R.string.social_predrink);
		
		//Save the last selected button for activity lifecycle
//		lastSelectedButton = 1;
	}
	
	public void clickedButton2(View view) {
		//Setup the webView
		WebView webView = (WebView) findViewById(R.id.webView);
		webView.loadUrl("file:///android_asset/travel.html");
		
		//Set the background image on each button
		LinearLayout buttoncont = (LinearLayout) findViewById(R.id.button1container);
		buttoncont.setBackgroundResource(R.drawable.button_unselected);
		LinearLayout button2cont = (LinearLayout) findViewById(R.id.button2container);
		button2cont.setBackgroundResource(R.drawable.button_selected);
		LinearLayout button3cont = (LinearLayout) findViewById(R.id.button3container);
		button3cont.setBackgroundResource(R.drawable.button_unselected);
		
		//Set the underline on selected button
		TextView textView = (TextView) findViewById(R.id.button1);
		textView.setText(R.string.social_nights);
		textView = (TextView) findViewById(R.id.button2);
		textView.setText(R.string.social_dealsU);
		textView = (TextView) findViewById(R.id.button3);
		textView.setText(R.string.social_predrink);
		
		//Save the last selected button for activity lifecycle
//		lastSelectedButton = 2;
	}
	
	public void clickedButton3(View view) {
		//Setup the webView
		WebView webView = (WebView) findViewById(R.id.webView);
		webView.loadUrl("http://homepages.cs.ncl.ac.uk/2013-14/csc2022_team14/clearing.html");
		
		//Set the background image on each button
		LinearLayout buttoncont = (LinearLayout) findViewById(R.id.button1container);
		buttoncont.setBackgroundResource(R.drawable.button_unselected);
		buttoncont = (LinearLayout) findViewById(R.id.button2container);
		buttoncont.setBackgroundResource(R.drawable.button_unselected);
		buttoncont = (LinearLayout) findViewById(R.id.button3container);
		buttoncont.setBackgroundResource(R.drawable.button_selected);
		
		//Set the underline on selected button
		TextView textView = (TextView) findViewById(R.id.button1);
		textView.setText(R.string.social_nights);
		textView = (TextView) findViewById(R.id.button2);
		textView.setText(R.string.social_deals);
		textView = (TextView) findViewById(R.id.button3);
		textView.setText(R.string.social_predrinkU);
		
		//Save the last selected button for activity lifecycle
//		lastSelectedButton = 3;
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
