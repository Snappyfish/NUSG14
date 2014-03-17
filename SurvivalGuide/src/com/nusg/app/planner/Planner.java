package com.nusg.app.planner;

import java.util.ArrayList;
import java.util.List;

import com.nusg.app.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class Planner extends Activity {

//	public final static String EXTRA_MESSAGE = "com.nusg.app.Planner.MESSAGE";
	private List<Event> calendarItems = new ArrayList<Event>();
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.nusg.app.R.layout.planner_main);
		
		populateEventList();
		populateListView();
		registerClickCallback();
	}
	

	private void populateEventList() {
		calendarItems.add(new Event("Event 1", 5, 6, "This is event one."));
		calendarItems.add(new Event("Event 2", 1, 8, "This is event two."));
		calendarItems.add(new Event("Event 3", 6, 7, "AIFBGASKUJYGFBJKASHYGDKJASGVD"));
		calendarItems.add(new Event("Event 4", 2, 3, "This is event SDFSDF."));
		calendarItems.add(new Event("Event 5", 1, 8, "This is event tdagfrdfgrdgdwo."));
		calendarItems.add(new Event("Event 6", 6, 7, "AIFBGASKUJYGFBJKASHYGDKJASGVDdsgadfgsdgsdrfgdrgsredfggdrf"));
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
			String timeString = currentEvent.getStartTime() + " to " + currentEvent.getEndTime();
			eventTime.setText(timeString);
			
			//Set description
			TextView eventDesc = (TextView) itemView.findViewById(R.id.itemEventDescription);
			eventDesc.setText(currentEvent.getDescription());
			
			return itemView;
		}
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
	
	
	
	private void registerClickCallback() {
		ListView list = (ListView) findViewById(R.id.eventList);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View viewCLicked, int position, long id) {
				Event clickedEvent = calendarItems.get(position);
				String message = "AAAAAAAA " + clickedEvent.getName();
				Toast.makeText(Planner.this, message, Toast.LENGTH_SHORT).show();
			}
		});
		
	}
	
	
}
