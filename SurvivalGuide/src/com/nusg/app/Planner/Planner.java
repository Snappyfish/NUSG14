package com.nusg.app.Planner;

import com.nusg.app.R;
import com.nusg.app.R.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.view.View;
import android.widget.CalendarView;

@SuppressLint("NewApi")
public class Planner extends Activity {

	public final static String EXTRA_MESSAGE = "com.nusg.app.Planner.MESSAGE";
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.nusg.app.R.layout.planner_main);
	}
	
	public void addEvent(View view) {
//		Intent intent = new Intent(this, AddEvent.class);
//		CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
//		long selectedDay = calendarView.getDate();
//    	intent.putExtra(EXTRA_MESSAGE, selectedDay);
//    	startActivity(intent);
		
		CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
		Intent intent = new Intent(Intent.ACTION_INSERT)
		        .setData(Events.CONTENT_URI)
		        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, calendarView.getDate());

		startActivity(intent);

    }
	
	public void editEvents(View view) {
//    	Intent intent = new Intent(this, DisplayMessageActivity.class);
//    	startActivity(intent);

    }
	
	
	
}
