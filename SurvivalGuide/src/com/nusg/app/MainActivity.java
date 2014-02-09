package com.nusg.app;

import com.nusg.app.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button contacts, preAcceptance, essentials, students, social, planner;
	Button[] ButtonArr = { contacts, preAcceptance, essentials, students,
			social, planner };
	int[] idArr = { com.nusg.app.R.id.contacts,
			com.nusg.app.R.id.preAcceptance, com.nusg.app.R.id.essentials,
			com.nusg.app.R.id.students, com.nusg.app.R.id.social,
			com.nusg.app.R.id.myPlanner };

	int count = 0;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		for (int i = 0; i < 6; i++) {
			ButtonArr[i] = (Button) findViewById(idArr[i]);
		}

		ButtonArr[count++].setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg) {

				Intent openContacts = new Intent("com.nusg.app.CONTACTS");
				startActivity(openContacts);
			}
		});

		ButtonArr[count++].setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg) {

				Intent openPreAcceptance = new Intent(
						"com.nusg.app.PREACCEPTANCE");
				startActivity(openPreAcceptance);
			}
		});

		ButtonArr[count++].setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg) {

				Intent openEssentials = new Intent("com.nusg.app.ESSENTIALS");
				startActivity(openEssentials);
			}
		});

		ButtonArr[count++].setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg) {

				Intent openStudent = new Intent("com.nusg.app.STUDENT");
				startActivity(openStudent);
			}
		});

		ButtonArr[count++].setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg) {

				Intent openSocial = new Intent("com.nusg.app.SOCIAL");
				startActivity(openSocial);
			}
		});

		ButtonArr[count++].setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg) {

				Intent openPlanner = new Intent("com.nusg.app.PLANNER");
				startActivity(openPlanner);

			}
		});

	}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu; this adds items to the action bar if it is present.
	 * getMenuInflater().inflate(R.menu.main, menu); return true; }
	 */
}