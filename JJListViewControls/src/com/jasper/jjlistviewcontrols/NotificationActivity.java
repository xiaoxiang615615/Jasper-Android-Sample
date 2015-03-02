package com.jasper.jjlistviewcontrols;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotificationActivity extends Activity {
	
	private NotificationManager notificationManager;
	private Button buttonNotification;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification_layout);
		notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.cancel(R.layout.notification_layout);
		buttonNotification = (Button)findViewById(R.id.buttonNotification);
		buttonNotification.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Notification nf = new Notification(R.drawable.ic_launcher, "test", SystemClock.currentThreadTimeMillis());
				nf.setLatestEventInfo(NotificationActivity.this, "JJ nf", "Notification", PendingIntent.getActivity(NotificationActivity.this, 1, getIntent(), 0));
				notificationManager.notify(R.layout.notification_layout, nf);
				
				//new Notification.Builder(NotificationActivity.this).setTicker("JJ test").setContentTitle("Not bad").setContentTitle("Good").setSmallIcon(R.drawable.ic_launcher).setContentIntent(PendingIntent.getActivity(NotificationActivity.this, 1, getIntent(), 0));
			}
		});
		
	} 
}
