package com.example.jjneolight;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements Runnable{

	TextView textView1;
	TextView textView2;
	TextView textView3;
	TextView textView4;
	TextView textView5;

	private int[] colors = new int[] { 0xFFFF0000, 0xFF00FF00, 0xFF0000FF,
			0xFFFF00FF, 0xFF00FFFF };

	private List<TextView> textViews;
	private int taskCounter = 5;
	private Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initActivity();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int counter = 0;
		switch (taskCounter%5) {
		case 0:
			counter = 0;
			break;
		case 1:
			counter = 1;
			break;
		case 2:
			counter = 2;
			break;
		case 3:
			counter = 3;
			break;
		case 4:
			counter = 4;
			break;
		}
		for(TextView textView : textViews)
		{
			if(counter > 4)
			{
				counter = counter-5;
			}
			try
			{
				textView.setBackgroundColor(colors[counter]);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			counter++;
		}
		taskCounter++;
		handler.postDelayed(this, 300);
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

	private void initActivity()
	{
		textView1 = (TextView)findViewById(R.id.textview1);
		textView2 = (TextView)findViewById(R.id.textview2);
		textView3 = (TextView)findViewById(R.id.textview3);
		textView4 = (TextView)findViewById(R.id.textview4);
		textView5 = (TextView)findViewById(R.id.textview5);
		textViews = new ArrayList<TextView>();
		textViews.add(textView1);
		textViews.add(textView2);
		textViews.add(textView3);
		textViews.add(textView4);
		textViews.add(textView5);
		handler = new Handler();
		handler.postDelayed(this, 300);
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		new AlertDialog.Builder(this).setTitle("Warning").setMessage("Are you sure to exit?").setPositiveButton("Ok", new OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				finish();
			}
		}).setNegativeButton("Cancel", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		}).show();
	}
}
