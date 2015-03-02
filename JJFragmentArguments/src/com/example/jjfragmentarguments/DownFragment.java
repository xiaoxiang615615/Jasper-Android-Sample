package com.example.jjfragmentarguments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DownFragment extends Fragment {
	
	private View view;
	Button buttonGetData;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.down_fragment, null);
		buttonGetData = (Button)view.findViewById(R.id.buttonDownFragment);
		buttonGetData.setText("Get data");
		buttonGetData.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			String arg = getFragmentManager().findFragmentById(R.id.fragmentDown).getArguments().getString("arg");
			TextView textView = (TextView)getActivity().findViewById(R.id.textViewDownFragment);
			textView.setText(arg);
			}
		});
		return view;
	}
}
