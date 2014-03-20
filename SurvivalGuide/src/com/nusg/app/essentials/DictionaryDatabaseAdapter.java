package com.nusg.app.essentials;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DictionaryDatabaseAdapter
{
	private static final String tableName = "Dictionary";
	private static final String id = "_id";
	public static final String word = "Word";
	public static final String definition = "Definition";
	
	private SQLiteDatabase db;
	private DictionaryDatabase database;
	private final Context context;
	
	public DictionaryDatabaseAdapter(Context context)
	{
		this.context = context;
	}
	
//	opens the connection to SQLite Database and our own database
	public DictionaryDatabaseAdapter open() throws SQLException
	{
		database = new DictionaryDatabase(context);
		db = database.getWritableDatabase();
		return this;
	}
	
//	closes the connection to SQLite Database
	public void close()
	{
		if(db != null)
		{
			db.close();
		}
	}
	
//	returns a pointer to the table
	public Cursor getAllWords()
	{
		Cursor cursor =  db.query(tableName, new String[] {id, word, definition}, null, null, null, null, word);

		if(cursor != null)
		{
			cursor.moveToFirst();
		}
		
		return cursor;
	}
	
//	returns pointer to a table of values that meet the requirements
	public Cursor getWord(String text) throws SQLException
	{
		Cursor cursor = null;
//		if there is no input then return every value or return values that is similar to input
		if (text == null  ||  text.length () == 0)
		{
			cursor = db.query(tableName, new String[] {id, word, definition}, null, null, null, null, word);
		}
		else 
		{
			cursor = db.query(true, tableName, new String[] {id, word, definition},word + " like '%" + text + "%'", null, null, null, null, null);
		}
		
		if(cursor != null)
		{
			cursor.moveToFirst();
		}
		
		return cursor;
	}
}
