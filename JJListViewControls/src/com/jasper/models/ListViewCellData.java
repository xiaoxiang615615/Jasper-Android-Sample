package com.jasper.models;

import java.util.List;

import android.content.Context;
import android.content.Intent;

public class ListViewCellData {
	private String controlName;
	private Context context;
	private Intent intent;
	public String getControlName() {
		return controlName;
	}
	public void setControlName(String controlName) {
		this.controlName = controlName;
	}
	public Context getContext() {
		return context;
	}
	public void setContext(Context context) {
		this.context = context;
	}
	public Intent getIntent() {
		return intent;
	}
	public void setIntent(Intent intent) {
		this.intent = intent;
	}
	
	public ListViewCellData(String controlName, Context context, Intent intent)
	{
		this.controlName = controlName;
		this.context = context;
		this.intent = intent;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getControlName();
	}
}
