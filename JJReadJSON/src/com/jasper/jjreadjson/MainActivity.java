package com.jasper.jjreadjson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		JSONObject jsonObject = new JSONObject();
		try {
			
			JSONObject lan1 = new JSONObject();
			lan1.put("id", 1);
			lan1.put("ide", "Elipse");
			lan1.put("name", "java");
			
			JSONObject lan2 = new JSONObject();
			lan2.put("id", 2);
			lan2.put("ide", "Xcode");
			lan2.put("name", "Swift");
			
			JSONObject lan3 = new JSONObject();
			lan3.put("id", 3);
			lan3.put("ide", "Visual studio");
			lan3.put("name", "C#");
			
			JSONArray array = new JSONArray();
			array.put(lan1);
			array.put(lan2);
			array.put(lan3);
			
			jsonObject.put("lan", array);
			
			jsonObject.put("cat", "it");
			
			System.out.println(jsonObject.toString());
			
			JSONObject jsonObject2 = new JSONObject(jsonObject.toString());
			String cat = jsonObject2.getString("cat");
			System.out.println("-----------------------------");
			System.out.println("Cat = "+cat);
			JSONArray jsonArray = jsonObject2.getJSONArray("lan");
			for (int i = 0; i < jsonArray.length(); i++) {
				System.out.println("-----------------------------");
				JSONObject object = (JSONObject) jsonArray.get(i);
				System.out.println("id = "+object.getInt("id"));
				System.out.println("ide = "+object.getString("ide"));
				System.out.println("name = "+object.getString("name"));
			}
			
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
