package com.jasper.jjlistviewcontrols;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ProgressDialogActivity extends Activity {
	
	private Button buttonProgressDialog;
	private ProgressDialog progressDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progress_dialog_layout);
		buttonProgressDialog = (Button)findViewById(R.id.buttonProgressDialog);
		buttonProgressDialog.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				progressDialog = ProgressDialog.show(ProgressDialogActivity.this, "JJ Warning", "Running......");
				new Thread()
				{
					public void run() {
						try
						{
							Thread.sleep(5000);
							progressDialog.dismiss();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
					};
				}.start();
			}
		});
		
	} 
}
