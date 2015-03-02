package com.jasper.jjreadwriteexternalfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	
	EditText et;
	TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);
        findViewById(R.id.btnsave).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				File sdcard = Environment.getExternalStorageDirectory();
				File myfile = new File(sdcard, "JJFile.txt");
				if(!sdcard.exists())
				{
					Toast.makeText(getApplicationContext(), "No SD card", Toast.LENGTH_SHORT).show();
					return;
				}
				try {
					myfile.createNewFile();
					FileOutputStream fileOutputStream = new FileOutputStream(myfile);
					OutputStreamWriter streamWriter = new OutputStreamWriter(fileOutputStream);
					streamWriter.write(et.getText().toString());
					streamWriter.flush();
					fileOutputStream.flush();
					streamWriter.close();
					fileOutputStream.close();
					Toast.makeText(getApplicationContext(), "File is created", Toast.LENGTH_SHORT).show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
        
        findViewById(R.id.btnread).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				File sdcard = Environment.getExternalStorageDirectory();
				File myfile = new File(sdcard, "JJFile.txt");
				if(!sdcard.exists())
				{
					Toast.makeText(getApplicationContext(), "No SD card", Toast.LENGTH_SHORT).show();
					return;
				}
				FileInputStream fileInputStream;
				try {
					fileInputStream = new FileInputStream(myfile);
					InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
					char[] data = new char[fileInputStream.available()];
					inputStreamReader.read(data);
					tv.setText(new String(data));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
//				inputStreamReader.read
			}
		});
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
}
