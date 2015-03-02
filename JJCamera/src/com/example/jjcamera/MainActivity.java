package com.example.jjcamera;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	SurfaceView surfaceView;
	Camera camera;
	SurfaceHolder holder;
	Callback surfaceHolderCallBack = new Callback() {

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			stopCamera();
		}

		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			startCamera();
		}

		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			// TODO Auto-generated method stub

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		surfaceView = (SurfaceView)findViewById(R.id.surfaceView);
		holder = surfaceView.getHolder();
		holder.addCallback(surfaceHolderCallBack);

		findViewById(R.id.btnTakePic).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				camera.takePicture(null, null, new PictureCallback() {
					
					@Override
					public void onPictureTaken(byte[] data, Camera camera) {
						// TODO Auto-generated method stub
						String imagePath;
						
						if((imagePath = saveTempFile(data))!= null)
						{
							Intent intent = new Intent(MainActivity.this, ImagePreviewActivity.class);
							intent.putExtra("path", imagePath);
							startActivity(intent);
						}
						else
						{
							Toast.makeText(MainActivity.this, "Save pic failed", Toast.LENGTH_SHORT).show();
						}
					}
				});
			}
		});
	}
	
	private String saveTempFile(byte[] bytes)
	{
		try {
			File f = File.createTempFile("img", "");
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(bytes);
			fos.flush();
			fos.close();
			return f.getAbsolutePath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
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

	private void startCamera()
	{
		camera = Camera.open();
		try {
			camera.setPreviewDisplay(holder);
//			camera.setDisplayOrientation(90);
			camera.startPreview();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void stopCamera()
	{
		camera.stopPreview();
		camera.release();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		surfaceView = (SurfaceView)findViewById(R.id.surfaceView);
		holder = surfaceView.getHolder();

		holder.addCallback(surfaceHolderCallBack);
	}
}
