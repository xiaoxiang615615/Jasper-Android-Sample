package com.jasper.jjclock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.DataFormatException;

import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TimePicker;

import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;
import com.fortysevendeg.swipelistview.SwipeListViewListener;
import com.jasper.jjclock.adapter.AlarmListAdapter;
import com.jasper.jjclock.listcell.AlarmCell;


public class MainActivity extends ActionBarActivity {

	TabHost host;
	TextView tvClock;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findControls();
		init();
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

	private void findControls(){
		tvClock = (TextView) findViewById(R.id.tvclock);
		host = (TabHost) findViewById(android.R.id.tabhost);
		host.setup();
	}

	private void init(){
		host.addTab(host.newTabSpec("Clock Tab").setContent(R.id.tabClock).setIndicator("Clock"));
		host.addTab(host.newTabSpec("Alarm Tab").setContent(R.id.tabAlarm).setIndicator("Alarm"));
		host.addTab(host.newTabSpec("Tab3").setContent(R.id.tab3).setIndicator("Tab3"));
		host.addTab(host.newTabSpec("Tab4").setContent(R.id.tab4).setIndicator("Tab4"));

		setClock();
		initAlarmList();
	}

	private boolean setClock(){
		Timer timer = new Timer();
		final Handler handler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				tvClock.setText(msg.getData().getString("Time"));
			}
		};
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Message message = handler.obtainMessage();
				Bundle bundle = new Bundle();
				bundle.putString("Time", getCurrentTime());
				message.setData(bundle);
				handler.sendMessage(message);
			}
		};
		timer.schedule(task, 1000, 1000);
		return true;
	}

	private String getCurrentTime(){
		Calendar calendar = Calendar.getInstance();
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		return format.format(calendar.getTime());
	}

	private void initAlarmList(){
		Button btnAdd = (Button) findViewById(R.id.btnAdd);
		SwipeListView lvAlarm = (SwipeListView) findViewById(R.id.lvAlarm);
		final AlarmListAdapter<AlarmCell> adapter = new AlarmListAdapter<AlarmCell>(MainActivity.this);

		lvAlarm.setAdapter(adapter);

		btnAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Calendar calendar = Calendar.getInstance();
				int hour = calendar.get(Calendar.HOUR_OF_DAY);
				int minute = calendar.get(Calendar.MINUTE);

				TimePickerDialog pickerDialog = new TimePickerDialog(MainActivity.this, new OnTimeSetListener() {

					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						// TODO Auto-generated method stub
						if (view.isShown()) {
							AlarmCell alarmCell = new AlarmCell();
							alarmCell.setAlarmTime(String.valueOf(String.format("%02d",hourOfDay))+" : "+String.valueOf(String.format("%02d",minute)));
							adapter.add(alarmCell);
						}
					};
				}, hour, minute, true);
				pickerDialog.show();

			}
		});

		lvAlarm.setSwipeListViewListener(new BaseSwipeListViewListener() {
			@Override
			public void onOpened(int position, boolean toRight) {
			}

			@Override
			public void onClosed(int position, boolean fromRight) {
			}

			@Override
			public void onListChanged() {
			}

			@Override
			public void onMove(int position, float x) {
			}

			@Override
			public void onStartOpen(int position, int action, boolean right) {
				Log.d("swipe", String.format("onStartOpen %d - action %d", position, action));
			}

			@Override
			public void onStartClose(int position, boolean right) {
				Log.d("swipe", String.format("onStartClose %d", position));
			}

			@Override
			public void onClickFrontView(int position) {
				Log.d("swipe", String.format("onClickFrontView %d", position));


				//                swipelistview.openAnimate(position); //when you touch front view it will open


			}

			@Override
			public void onClickBackView(int position) {
				Log.d("swipe", String.format("onClickBackView %d", position));

				//                swipelistview.closeAnimate(position);//when you touch back view it will close
			}

			@Override
			public void onDismiss(int[] reverseSortedPositions) {

			}

		});


	}
}
