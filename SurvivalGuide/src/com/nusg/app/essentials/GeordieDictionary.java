package com.nusg.app.essentials;
 
import com.nusg.app.R;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
 
public class GeordieDictionary extends Activity 
{
 
	private DictionaryDatabaseAdapter database;
	private SimpleCursorAdapter adapter;
	 
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dictionary);
		 
		database = new DictionaryDatabaseAdapter(this);
		database.open();
		 
		displayListView();
	}
	 
//	display the list from SQLite Database
	private void displayListView() 
	{
		Cursor cursor = database.getAllWords();
			 
//		columns in the database to be put into each row 
		String[] columns = new String[] {DictionaryDatabaseAdapter.word, DictionaryDatabaseAdapter.definition};
			 
//		the defined views in XML that each text will go into 
		int[] ids = new int[] {R.id.word, R.id.definition};
		
//		adapter that uses the cursor to point to data and layout information
		adapter = new SimpleCursorAdapter(this, R.layout.dictionary_single_row, cursor, columns, ids, 0);
			 
		ListView listView = (ListView) findViewById(R.id.list);
//		set the adapter to the list view
		listView.setAdapter(adapter);
			 
		EditText search = (EditText) findViewById(R.id.search);
		search.addTextChangedListener(new TextWatcher() 
		{
//			methods that must be implemented
			public void afterTextChanged(Editable s) {}
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
			
//			filters out the words according to what the user types
			public void onTextChanged(CharSequence s, int start, int before, int count) 
			{
				adapter.getFilter().filter(s.toString());
			}
		});
			   
//		gets all the similar words to what the user entered
		adapter.setFilterQueryProvider(new FilterQueryProvider()
		{
			public Cursor runQuery(CharSequence constraint) 
			{
				return database.getWord(constraint.toString());
			}
		});
	 
	}
}







