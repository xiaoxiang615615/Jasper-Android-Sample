package com.jasper.jjfragmentcallback;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BottomFragment extends Fragment {

	View view;
	private boolean updateTextViewFlag = false;
	private String value;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.bottom_fragment, container, false);
		return view;
	}

	public void updateTextView(String value)
	{
		if(updateTextViewFlag)
		{
			TextView textView = (TextView)getView().findViewById(R.id.textviewDownFragment);
			textView.setText(value);
		}	
		else
		{
			updateTextViewFlag = !updateTextViewFlag;
			this.value = value;
		}
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if(updateTextViewFlag)
		{
			TextView textView = (TextView)getView().findViewById(R.id.textviewDownFragment);
			textView.setText(value);
		}
		super.onActivityCreated(savedInstanceState);
	}

}
