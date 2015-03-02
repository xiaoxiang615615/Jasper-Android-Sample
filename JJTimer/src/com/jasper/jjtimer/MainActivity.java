package com.jasper.jjtimer;

import java.util.Timer;
import java.util.TimerTask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	EditText editTextTime;
	Button btnGetTime;
	Button btnStartCount;
	Button btnStopCount;
	TextView textViewTime;
	int i;
	Timer timer = null;
	TimerTask timerTask = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editTextTime = (EditText) findViewById(R.id.edittextTime);
		btnGetTime = (Button) findViewById(R.id.btnGetTime);
		btnStartCount = (Button) findViewById(R.id.btnStartCount);
		btnStopCount = (Button) findViewById(R.id.btnStopCount);
		textViewTime = (TextView) findViewById(R.id.textviewTime);
		btnGetTime.setOnClickListener(this);
		btnStartCount.setOnClickListener(this);
		btnStopCount.setOnClickListener(this);

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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnGetTime:
			textViewTime.setText(editTextTime.getText().toString().trim());
			i = Integer.valueOf(editTextTime.getText().toString().trim());
			editTextTime.setText(editTextTime.getText().toString().trim());
			Toast.makeText(MainActivity.this, "The input time to count is "+String.valueOf(i), Toast.LENGTH_SHORT).show();
			break;

		case R.id.btnStartCount:
			
//			AsyncTask<String, Void, Void> task = new AsyncTask<String, Void, Void>(){
//
//				@Override
//				protected Void doInBackground(String... params) {
//					// TODO Auto-generated method stub
//					while(i > 0)
//					{
//
////						Handler handler =  new Handler(MainActivity.this.getMainLooper());
////						handler.post( new Runnable(){
////							public void run(){
////								Toast.makeText(MainActivity.this, String.valueOf(i), Toast.LENGTH_SHORT).show();
////							}
////						});
////						try {
////							Thread.sleep(1000);
////						} catch (InterruptedException e) {
////							// TODO Auto-generated catch block
////							e.printStackTrace();
////						}
//						
//						textViewTime.setText(String.valueOf(i));
//						try {
//							Thread.sleep(1000);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//
//						i--;
//
//					}
//					return null;
//				}
//
//			}.execute();
			
			startTime();
			break;

		case R.id.btnStopCount:
			stopTime();
			break;

		default:
			break;
		}
	}
	
	private Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			textViewTime.setText(String.valueOf(msg.arg1));
			startTime();
		};
	};
	
	private void startTime(){
		timer = new Timer();
		timerTask = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				i--;
				Message message = handler.obtainMessage();
				message.arg1 = i;
				handler.sendMessage(message);
			}
		};
		
		timer.schedule(timerTask, 1000);
	}
	
	private void stopTime(){
		timer.cancel();
	}
}