package com.jasper.jjfragmentcallback;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class UpFragment extends Fragment implements OnClickListener {
	
	private onTopButtonClickListener listener;

	public interface onTopButtonClickListener
	{
		public void onclick(String name);
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		if(getActivity() instanceof onTopButtonClickListener)
		{
			listener = (onTopButtonClickListener)getActivity();
		}
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.up_fragment, null);
		Button buttonTopFragment = (Button)view.findViewById(R.id.buttonUpFragment);
		buttonTopFragment.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		listener.onclick("JJ Top Button Click");
	}
	
}
