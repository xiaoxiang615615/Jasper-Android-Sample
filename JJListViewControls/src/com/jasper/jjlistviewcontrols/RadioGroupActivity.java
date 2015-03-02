package com.jasper.jjlistviewcontrols;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RadioGroupActivity extends Activity {
	Button buttonSubmit;
	RadioGroup radioGroup;
	RadioButton radioButtonYes;
	RadioButton radioButtonNo;
	RadioButton radioButtonNotSure;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radio_group_layout);
		initRadioGroupActivity();		
	} 
	
	private boolean initRadioGroupActivity()
	{
		buttonSubmit = (Button)findViewById(R.id.buttonSubmit);
		radioGroup = (RadioGroup)findViewById(R.id.radioGroup1);
		radioButtonYes = (RadioButton)findViewById(R.id.radioYes);
		radioButtonNo = (RadioButton)findViewById(R.id.radioNo);
		radioButtonNotSure = (RadioButton)findViewById(R.id.radioNotSure);
		
		buttonSubmit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int buttonId = RadioGroupActivity.this.radioGroup.getCheckedRadioButtonId();
				if(radioButtonYes.isChecked())
				{
					new AlertDialog.Builder(RadioGroupActivity.this).setTitle("Correct").setMessage("Yes, correct!").setPositiveButton("Ok", null).show();
				}
				else
				{
					new AlertDialog.Builder(RadioGroupActivity.this).setTitle("Wrong").setMessage("No, please select again!").setPositiveButton("Ok", null).show();
				}
			}
		});
		return true;
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
}
