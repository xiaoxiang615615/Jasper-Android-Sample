package com.example.jjfragmentarguments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class UpFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.up_fragment, null);
		Button buttonUp = (Button)view.findViewById(R.id.buttonUpFragment);
		buttonUp.setText("Send Data");
		buttonUp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fraManager = getFragmentManager();
				Bundle bundle = new Bundle();
				bundle.putString("arg", "data to pass");
				FragmentTransaction fragmentTransaction = fraManager.beginTransaction();
				DownFragment downFragment = new DownFragment();
				downFragment.setArguments(bundle);
				fragmentTransaction.add(R.id.fragmentDown, downFragment, "fragmentDown");
				fragmentTransaction.commit();
				Toast.makeText(getActivity(), "Data is passed", 1000).show();
			}
		});
		return view;
	}
}
