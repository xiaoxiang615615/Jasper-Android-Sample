package com.jasper.jjlistviewcontrols;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextActivity extends Activity {
	
	Button buttonEditText;
	EditText editText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_text_layout);
		
		buttonEditText = (Button)findViewById(R.id.buttonEditText);
		editText = (EditText)findViewById(R.id.editText1);
		
		buttonEditText.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(TextUtils.isEmpty(editText.getText().toString()))
				{
					Toast.makeText(EditTextActivity.this, "EditText is empty", 1000).show();
				}
				else
				{
					Toast.makeText(EditTextActivity.this, editText.getText().toString(), 1000).show();
				}
				
			}
		});
		
	}
}
