package com.nusg.app.essentials;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.nusg.app.R;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper
{
	private static final String TAG = "Database";
	private static final String databaseName = "Dictionary";
	private static final int databaseVersion = 2;
	private static final String tableName = "Dictionary";
	private static final String id = "_id";
	private static final String word = "Word";
	private static final String definition = "Definition";
	private static final String CREATE_TABLE = "CREATE TABLE if not exists " + tableName + " (" + 
			id + " integer primary key autoincrement, " + 
			word + " text not null, " + 
			definition + " text not null);";
	private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + tableName;
	private Context context;
	
	public Database(Context context)
	{
		super(context, databaseName, null, databaseVersion);
		this.context = context;
	}

	@Override
//	calls when database is opened and inserts values if they aren't already there
	public void onCreate(SQLiteDatabase db)
	{
		Log.w(TAG, CREATE_TABLE);
		db.execSQL(CREATE_TABLE);
		insert(db);
	}

	@Override
//	calls when the database is updated i.e. database version is increased
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		Log.w(TAG, "Upgrading database from OLD_VERSION: " + oldVersion + " to NEW_VERSION: " + newVersion);
		db.execSQL(DROP_TABLE);
		onCreate(db);
	}
	
//	inserts all the values to database
	private void insert(SQLiteDatabase db) 
	{
		try
		{
//			gets all values from the file 'dictionary'
			InputStream is = context.getResources().openRawResource(R.raw.dictionary);
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String strLine = null;

//			reads through each line in file
			while ((strLine = (reader.readLine()).trim()) != null) {
				String[] temp;
				
//				splits each line into different strings where there is an equal sign and puts it into array
				temp = strLine.split("=");

				ContentValues values = new ContentValues();

//				adds values to database table
				values.put(word, temp[0].trim());
				values.put(definition, temp[1].trim());

				db.insert(tableName, null, values);
			}
			is.close();
			Log.w(TAG, "Values inserted");
		}
		catch (Exception e)
		{
			Log.w(TAG, "Exception in INSERT: " + e);
		}

	}
}
