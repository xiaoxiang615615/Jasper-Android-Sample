package com.jasper.jjlistviewcontrols;

import android.R.array;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;

import com.jasper.models.ListViewCellData;

public class MainActivity extends ActionBarActivity {

	private ListView listView;
	private ArrayAdapter<ListViewCellData> arrayAdaper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initActivity();
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
	
	private boolean initActivity()
	{
		listView = (ListView)findViewById(R.id.listView1);
		arrayAdaper = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
		arrayAdaper.add(new ListViewCellData("JJ Radio Group", this, new Intent(this, RadioGroupActivity.class)));
		arrayAdaper.add(new ListViewCellData("JJ Date Picker", this, new Intent(this, DatePicker.class))); 
		arrayAdaper.add(new ListViewCellData("JJ Time Picker", this, new Intent(this, TimePicker.class)));
		arrayAdaper.add(new ListViewCellData("JJ Progress Bar", this, new Intent(this, ProgressBarActivity.class)));
		arrayAdaper.add(new ListViewCellData("JJ Seek Bar", this, new Intent(this, SeekBarActivity.class)));
		arrayAdaper.add(new ListViewCellData("JJ Progress Dialog", this, new Intent(this, ProgressDialogActivity.class)));
		arrayAdaper.add(new ListViewCellData("JJ Notification", this, new Intent(this, NotificationActivity.class)));
		arrayAdaper.add(new ListViewCellData("JJ Image Switcher", this, new Intent(this, ImageSwitcherActivity.class)));
		arrayAdaper.add(new ListViewCellData("JJ Gallery", this, new Intent(this, GalleryActivity.class)));
		arrayAdaper.add(new ListViewCellData("JJ Rating Bar", this, new Intent(this, RatingBarActivity.class)));
		arrayAdaper.add(new ListViewCellData("JJ EditText", this, new Intent(this, EditTextActivity.class)));
		
		listView.setAdapter(arrayAdaper);
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intentToStart = MainActivity.this.arrayAdaper.getItem(position).getIntent();
				startActivity(intentToStart);
			}
		});
		return true;
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		new AlertDialog.Builder(this).setTitle("Warning").setMessage("Are you sure to exit?").setPositiveButton("Yes", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
			}
		}).setNegativeButton("No", null).show();
	}
}
