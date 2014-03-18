package com.nusg.app.planner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.nusg.app.R;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Planner extends Activity {

	private List<Event> calendarItems = new ArrayList<Event>();
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.nusg.app.R.layout.planner_main);
		
		populateEventList();
		populateListView();
		registerClickCallback();
	}
	

	private void populateEventList() {
		
		ContentResolver contentResolver = this.getContentResolver();
		long now = new Date().getTime();
		
        Cursor cursor = contentResolver.query(
        		Uri.parse("content://com.android.calendar/events"), 		//Uri to the calendar events table
        		(new String[] { "title", "description", "dtstart", "dtend"}), 	//The fields to copy over
        		"( dtend > " + now + ")",			//SQL "Where" clause to select which rows to copy
        		null,		//sth
        		"dtstart ASC");			//order by
        try {
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                	Event newEvent = new Event(cursor.getString(0), cursor.getString(1), cursor.getLong(2), cursor.getLong(3));
                	
					calendarItems.add(newEvent);
                }
            }
        } catch (AssertionError ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	private void populateListView() {
		
		ArrayAdapter<Event> adapter = new ListAdapter();
		ListView list = (ListView) findViewById(R.id.eventList);
		list.setAdapter(adapter);
		
	}
	
	
	private class ListAdapter extends ArrayAdapter<Event> {
		public ListAdapter() {
			super(Planner.this, R.layout.calendar_item, calendarItems);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			//Ensure the view isn't null
			View itemView = convertView;
			if (itemView == null) {
				itemView = getLayoutInflater().inflate(R.layout.calendar_item, parent, false);
			}
			
			//Find the current event to use
			Event currentEvent = calendarItems.get(position);
			
			//Replace default text with event information
			//Set name
			TextView eventName = (TextView) itemView.findViewById(R.id.itemEventName);
			eventName.setText(currentEvent.getName());
			
			//Set time
			TextView eventTime = (TextView) itemView.findViewById(R.id.itemEventTime);
			Date startTime = new Date(currentEvent.getStartTime());
			Date endTime = new Date(currentEvent.getEndTime());
			String allDayFormat = "cccc d LLLL";
			String sameDayFormatPre = "h':'mma 'to' ";
			String sameDayFormatPost = "h':'mma',' cccc d LLLL";
			String multiDayFormatPostPre = "h':'mma cccc d 'to' ";
			String multiDayFormatPostPost = "h':'mma cccc d',' LLLL";
			String multiMonthFormatPostPre = "h':'mma cccc d LLLL 'to' ";
			String multiMonthFormatPostPost = "h':'mma cccc d LLLL";
			
			Calendar startTimeCal = Calendar.getInstance();
			startTimeCal.setTime(startTime);
			Calendar endTimeCal = Calendar.getInstance();
			endTimeCal.setTime(endTime);
			
			
			if(endTimeCal.getTimeInMillis() - startTimeCal.getTimeInMillis() == DateUtils.DAY_IN_MILLIS && startTime.getTime()%DateUtils.DAY_IN_MILLIS == 0) {	//all-day event
				SimpleDateFormat sdf = new SimpleDateFormat(allDayFormat, Locale.getDefault());
				eventTime.setText(sdf.format(startTime));
			} else if(startTimeCal.get(Calendar.DAY_OF_YEAR) == endTimeCal.get(Calendar.DAY_OF_YEAR)) {		//Event starts and ends in the same day
				SimpleDateFormat sdf1 = new SimpleDateFormat(sameDayFormatPre, Locale.getDefault());
				SimpleDateFormat sdf2 = new SimpleDateFormat(sameDayFormatPost, Locale.getDefault());
				eventTime.setText(sdf1.format(startTime) + sdf2.format(endTime));
			} else if(startTimeCal.get(Calendar.MONTH) == endTimeCal.get(Calendar.MONTH)) {		//Event starts and ends in different days
				SimpleDateFormat sdf1 = new SimpleDateFormat(multiDayFormatPostPre, Locale.getDefault());
				SimpleDateFormat sdf2 = new SimpleDateFormat(multiDayFormatPostPost, Locale.getDefault());
				eventTime.setText(sdf1.format(startTime) + sdf2.format(endTime));
			} else {		//Event starts and ends in different months
				SimpleDateFormat sdf1 = new SimpleDateFormat(multiMonthFormatPostPre, Locale.getDefault());
				SimpleDateFormat sdf2 = new SimpleDateFormat(multiMonthFormatPostPost, Locale.getDefault());
				eventTime.setText(sdf1.format(startTime) + sdf2.format(endTime));
			}
			
			
			//Set description
			TextView eventDesc = (TextView) itemView.findViewById(R.id.itemEventDescription);
			eventDesc.setText(currentEvent.getDesc());
			
			return itemView;
		}
	}
	
	
	public void addEvent(View view) {
		CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
		Intent intent = new Intent(Intent.ACTION_INSERT)
		        .setData(Events.CONTENT_URI)
		        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, calendarView.getDate());

		startActivity(intent);

    }
	
	public void editEvents(View view) {
		CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
		
		Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
		builder.appendPath("time");
		ContentUris.appendId(builder, calendarView.getDate());
		Intent intent = new Intent(Intent.ACTION_VIEW)
		    .setData(builder.build());
		startActivity(intent);
		
    }
	
	
	
	private void registerClickCallback() {
		ListView list = (ListView) findViewById(R.id.eventList);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View viewCLicked, int position, long id) {
				Event clickedEvent = calendarItems.get(position);
				String a = String.valueOf(clickedEvent.getStartTime());
				String b = String.valueOf(clickedEvent.getEndTime());
				String message = a + " to " + b;
				Toast.makeText(Planner.this, message, Toast.LENGTH_LONG).show();
			}
		});
		
	}
	
	
}
