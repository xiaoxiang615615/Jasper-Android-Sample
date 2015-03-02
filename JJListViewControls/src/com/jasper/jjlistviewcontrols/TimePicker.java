package com.jasper.jjlistviewcontrols;

import java.util.Calendar;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

public class TimePicker extends Activity {
	
	private EditText editText;
	private Button buttonPickTime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.time_picker_layout);
		editText = (EditText)findViewById(R.id.editText1);
		buttonPickTime = (Button)findViewById(R.id.buttonPickTime);
		buttonPickTime.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Calendar cal = Calendar.getInstance();
				int hour = cal.get(Calendar.HOUR);
				int min = cal.get(Calendar.MINUTE);
				int sec = cal.get(Calendar.SECOND);
				
				new TimePickerDialog(TimePicker.this, new OnTimeSetListener() {
				@Override
				public void onTimeSet(android.widget.TimePicker view,
						int hourOfDay, int minute) {
					// TODO Auto-generated method stub
					editText.setText(String.format("%02d", hourOfDay)+String.format("%02d", minute));
				}
				}, hour, min, true).show();
			}
		});
	} 
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
}
