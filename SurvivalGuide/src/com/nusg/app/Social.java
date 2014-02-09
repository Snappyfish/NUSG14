package com.nusg.app;

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
	
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.social);
		
		
		
//	}
}