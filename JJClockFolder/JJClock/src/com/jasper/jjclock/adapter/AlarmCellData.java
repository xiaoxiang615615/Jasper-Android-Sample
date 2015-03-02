package com.jasper.jjclock.adapter;

import android.graphics.drawable.Drawable;

public class AlarmCellData {
	private String alarmTime;

	public String getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}
	
	public AlarmCellData(String alarmTime) {
		super();
		this.alarmTime = alarmTime;
	}
}
