package com.jasper.jjfilebrowser;

import java.io.File;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	ListView listview;
	//	ArrayAdapter<JJFile> adaper;
	JJAdaper adaper;
	File f;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview = (ListView)findViewById(R.id.ListView1);
		//		adaper = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
		//		File f = new File("/");
		//		File[] files = f.listFiles();
		//		for (File file : files) {
		//			adaper.add(new JJFile(file));
		//		}
		//		listview.setAdapter(adaper);
		String path = getIntent().getStringExtra("path");
		adaper = new JJAdaper(this);
		if(path == null)
		{
			f = new File("/");
		}
		else
		{
			f = new File(path);
		}
		File[] files = f.listFiles();

		if(files != null)
		{
			for (File file : files) {
				adaper.add(file);
			}
		}
		listview.setAdapter(adaper);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				String path = ((File)adaper.getItem(arg2)).getAbsolutePath();
				Intent intent = new Intent(MainActivity.this, MainActivity.class);
				intent.putExtra("path", path);
				if(path != null && path.length() > 0)
				{
					startActivity(intent);				
				}
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
