package com.jasper.jjlistviewcontrols;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DatePicker extends Activity {
	
	private EditText editText;
	private Button buttonPickDate;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.date_picker_layout);
		editText = (EditText)findViewById(R.id.editTextDatePicker);
		buttonPickDate = (Button)findViewById(R.id.buttonPickDate);
		buttonPickDate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);
				int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
				
				new DatePickerDialog(DatePicker.this, new OnDateSetListener() {
					@Override
					public void onDateSet(android.widget.DatePicker view,
							int year, int monthOfYear, int dayOfMonth) {
						// TODO Auto-generated method stub
						//new AlertDialog.Builder(DatePicker.this).setTitle("Date picked").setMessage(String.valueOf(year)).setPositiveButton("Ok", null).show();
						editText.setText(String.valueOf(year)+String.format("%02d", monthOfYear+1)+String.format("%02d",dayOfMonth));
					}
				}, year, month, dayOfMonth).show();
			}
		});
		
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
}
