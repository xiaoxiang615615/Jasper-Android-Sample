package com.jasper.jjsqllite;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.jasper.models.user;


public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		db database = new db(getApplicationContext());
		//		SQLiteDatabase writeableDB = database.getWritableDatabase();
		//        ContentValues cv = new ContentValues();
		//        cv.put("name", "Jasper");
		//        cv.put("gender", "Male");
		//        writeableDB.insert("USER", null, cv);
		//        cv = new ContentValues();
		//        cv.put("name", "Sharon");
		//        cv.put("gender", "Female");
		//        writeableDB.insert("USER", null, cv);
		//		writeableDB.close();

		SQLiteDatabase readbleDB = database.getReadableDatabase();
		Cursor cursor = readbleDB.rawQuery("SELECT * FROM USER", null);
		String data = "";
		List<user> users = new ArrayList<user>();
		JJListViewAdaper adaper = new JJListViewAdaper(this);
		while(cursor.moveToNext())
		{
			data += cursor.getString(cursor.getColumnIndex("name"));
			data += cursor.getString(cursor.getColumnIndex("gender"));
			user user = new user();
			user.setName(cursor.getString(cursor.getColumnIndex("name")));
			user.setGender(cursor.getString(cursor.getColumnIndex("gender")));
			adaper.add(user);
		}
		System.out.println(data);
		
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(adaper);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
