package com.example.jjbaseadapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends ActionBarActivity {

	ListView listView;
	JJCustListCellAdapter<String> jjCustListCell;

	JJCustListCellAdapter<JJCustListCell> adaper;

	Button buttonAdd;
	Button buttonRemove;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView)findViewById(R.id.ListViewBaseAdapter);
		//		jjCustListCell = new JJCustListCellAdapter<String>(this, android.R.layout.simple_list_item_1) {
		//			
		//			@Override
		//			public void initView(int arg0, View arg1, ViewGroup arg2) {
		//				// TODO Auto-generated method stub
		//				((TextView)arg1).setText(getItem(arg0).toString());
		//			}
		//		};
		//		
		//		for(int i=0;i<10;i++)
		//		{
		//			jjCustListCell.add("JJ Item "+i);
		//		}
		//		
		//		listView.setAdapter(jjCustListCell);
		//		
		//		buttonAdd = (Button)findViewById(R.id.buttonAdd);
		//		buttonRemove = (Button)findViewById(R.id.buttonRemove);
		//		
		//		buttonAdd.setOnClickListener(new OnClickListener() {
		//			
		//			@Override
		//			public void onClick(View arg0) {
		//				// TODO Auto-generated method stub
		//				jjCustListCell.add("JJ Add");	
		//			}
		//		});
		//		
		//		buttonRemove.setOnClickListener(new OnClickListener() {
		//			
		//			@Override
		//			public void onClick(View v) {
		//				// TODO Auto-generated method stub
		//				if(jjCustListCell.getCount() > 0)
		//				{
		//					jjCustListCell.removeLast();
		//				}
		//				else
		//				{
		//					Toast.makeText(MainActivity.this, "No data to remove", 1000).show();
		//				}
		//			}
		//		});



		adaper = new JJCustListCellAdapter<JJCustListCell>(this, R.layout.jj_cust_listcell) {

			@Override
			public void initView(int arg0, View arg1, ViewGroup arg2) {
				// TODO Auto-generated method stub
				TextView textView = (TextView)((LinearLayout)arg1).findViewById(R.id.textView1);
				textView.setText(((JJCustListCell)adaper.getItem(arg0)).getTextView().getText());
				Button button = (Button)((LinearLayout)arg1).findViewById(R.id.button1);
				button.setText(((JJCustListCell)adaper.getItem(arg0)).getButton().getText());
			}
		};

		JJCustListCell cellData;
		for(int i=0; i<100; i++)
		{
			TextView textView = new TextView(MainActivity.this);
			textView.setText("TextView "+i);
			Button button = new Button(MainActivity.this);
			button.setText("Button "+i);
			cellData = new JJCustListCell(textView, button);
			adaper.add(cellData);
		}

		listView.setAdapter(adaper);

		buttonAdd = (Button)findViewById(R.id.buttonAdd);
		buttonRemove = (Button)findViewById(R.id.buttonRemove);

		buttonAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				TextView textView = new TextView(MainActivity.this);
				textView.setText("TextView JJ");
				Button button = new Button(MainActivity.this);
				button.setText("Button JJ");
				JJCustListCell cellData = new JJCustListCell(textView, button);
				adaper.add(cellData);
			}
		});

		buttonRemove.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(adaper.getCount() > 0)
				{
					adaper.removeLast();
				}
				else
				{
					Toast.makeText(MainActivity.this, "No data to remove", 1000).show();
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

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		new AlertDialog.Builder(this).setTitle("Warning").setMessage("Are you sure to exit?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
			}
		}).setNegativeButton("No", null).show();
	}
}
