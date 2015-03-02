package com.jasper.jjclock.listcell;

public class AlarmCell {

	private String alarmTime;
	
	
	public String getAlarmTime() {
		return alarmTime;
	}


	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}


	@Override
	public String toString() {
		return alarmTime;
	}
}
