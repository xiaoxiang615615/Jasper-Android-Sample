package com.jasper.jjlistviewcontrols;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarActivity extends Activity {
	
	private ProgressBar progressBar;
	private int i;
	private Button buttonReset;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progress_bar);
		
		buttonReset = (Button)findViewById(R.id.buttonReset);
		progressBar = (ProgressBar)findViewById(R.id.progressBar1);
		i = 1;
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(i<11)
				{
					progressBar.setProgress(i*10);
					i++;
				}
			}
		};
		timer.schedule(task, 1000, 1000);
		
		buttonReset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ProgressBarActivity.this.progressBar.setProgress(0);
				ProgressBarActivity.this.i = 0;
			}
		});
		
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
}
