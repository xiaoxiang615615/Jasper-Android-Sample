package com.jasper.jjdrawres;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	Button jjButon;
	NotificationManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		manager.cancel(R.layout.activity_main);
		jjButon = (Button)findViewById(R.id.jjButton);
		jjButon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Notification notification = new Notification(R.drawable.icon, "JJ notification", System.currentTimeMillis());
				notification.setLatestEventInfo(MainActivity.this, "JJ Notification Title", "JJ Notification Context", PendingIntent.getActivity(MainActivity.this, 1, getIntent(), 0));
				manager.notify(R.layout.activity_main, notification);
			}
		});
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
		switch (id) {
		case R.id.menu_showdialog:
			new AlertDialog.Builder(this).setTitle("JJ Show Dialog").setMessage("Show dialog is working!!!").setPositiveButton("Ok", null).show();
			break;
		case R.id.menu_showtoast:
			Toast.makeText(this, "Show toast is working!!!", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
