package com.example.jjbaseadapter;

import android.widget.Button;
import android.widget.TextView;

public class JJCustListCell {
	private TextView textView;
	private Button button;
	
	public JJCustListCell(TextView textView, Button button)
	{
		this.textView = textView;
		this.button = button;
	}
	
	public TextView getTextView() {
		return textView;
	}
	public void setTextView(TextView textView) {
		this.textView = textView;
	}
	public Button getButton() {
		return button;
	}
	public void setButton(Button button) {
		this.button = button;
	}
	

}
