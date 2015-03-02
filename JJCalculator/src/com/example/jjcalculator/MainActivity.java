package com.example.jjcalculator;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements android.view.View.OnClickListener {

	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	private Button button0;
	private Button buttonP;
	private Button buttonMi;
	private Button buttonMu;
	private Button buttonD;
	private Button buttonC;
	private Button buttonE;
	private TextView textViewCal;

	private List<Item> items = new ArrayList<>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initButtons();
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

	private void initButtons()
	{
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		button3 = (Button)findViewById(R.id.button3);
		button4 = (Button)findViewById(R.id.button4);
		button5 = (Button)findViewById(R.id.button5);
		button6 = (Button)findViewById(R.id.button6);
		button7 = (Button)findViewById(R.id.button7);
		button8 = (Button)findViewById(R.id.button8);
		button9 = (Button)findViewById(R.id.button9);
		button0 = (Button)findViewById(R.id.button0);
		buttonP = (Button)findViewById(R.id.buttonP);
		buttonMi = (Button)findViewById(R.id.buttonMi);
		buttonMu= (Button)findViewById(R.id.buttonMu);
		buttonD = (Button)findViewById(R.id.buttonD);
		buttonC = (Button)findViewById(R.id.buttonC);
		buttonE = (Button)findViewById(R.id.buttonE);
		textViewCal = (TextView)findViewById(R.id.TextViewCal);

		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
		button5.setOnClickListener(this);
		button6.setOnClickListener(this);
		button7.setOnClickListener(this);
		button8.setOnClickListener(this);
		button9.setOnClickListener(this);
		button0.setOnClickListener(this);
		buttonP.setOnClickListener(this);
		buttonMi.setOnClickListener(this);
		buttonMu.setOnClickListener(this);
		buttonD.setOnClickListener(this);
		buttonC.setOnClickListener(this);
		buttonE.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button0:
			textViewCal.append("0");
			break;
		case R.id.button1:
			textViewCal.append("1");
			break;
		case R.id.button2:
			textViewCal.append("2");
			break;
		case R.id.button3:
			textViewCal.append("3");
			break;
		case R.id.button4:
			textViewCal.append("4");
			break;
		case R.id.button5:
			textViewCal.append("5");
			break;
		case R.id.button6:
			textViewCal.append("6");
			break;
		case R.id.button7:
			textViewCal.append("7");
			break;
		case R.id.button8:
			textViewCal.append("8");
			break;
		case R.id.button9:
			textViewCal.append("9");
			break;
		case R.id.buttonP:
			items.add(new Item(Double.parseDouble(textViewCal.getText().toString()), Types.Num));
			checkAndCal();
			items.add(new Item(0, Types.ADD));
			textViewCal.setText("");
			break;
		case R.id.buttonMi:
			items.add(new Item(Double.parseDouble(textViewCal.getText().toString()), Types.Num));
			checkAndCal();
			items.add(new Item(0, Types.Mi));
			textViewCal.setText("");
			break;
		case R.id.buttonMu:
			items.add(new Item(Double.parseDouble(textViewCal.getText().toString()), Types.Num));
			checkAndCal();
			items.add(new Item(0, Types.Mu));
			textViewCal.setText("");
			break;
		case R.id.buttonD:
			items.add(new Item(Double.parseDouble(textViewCal.getText().toString()), Types.Num));
			checkAndCal();
			items.add(new Item(0, Types.Div));
			textViewCal.setText("");
			break;
		case R.id.buttonC:
			textViewCal.setText("");
			items.clear();
			break;
		case R.id.buttonE:
			items.add(new Item(Double.parseDouble(textViewCal.getText().toString()), Types.Num));
			checkAndCal();
			textViewCal.setText(String.valueOf(items.get(0).value));
			items.clear();
			break;
		}
	}


	private void checkAndCal()
	{
		if(items.size() >= 3)
		{
			double a = items.get(0).value;
			double b = items.get(2).value;
			int opt = items.get(1).type;
			items.clear();
			switch (opt) {
			case Types.ADD:
				items.add(new Item(a+b, Types.Num));
				break;
			case Types.Mi:
				items.add(new Item(a-b, Types.Num));
				break;
			case Types.Div:
				items.add(new Item(a/b, Types.Num));
				break;
			case Types.Mu:
				items.add(new Item(a*b, Types.Num));
				break;
			default:
				break;
			}
		}
	}
}
