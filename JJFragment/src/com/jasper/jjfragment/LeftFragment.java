package com.jasper.jjfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class LeftFragment extends Fragment {
	
	ListView listView;
	ArrayAdapter<String> arrayAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View view = inflater.inflate(R.layout.left_fragement, null);
		listView = (ListView)view.findViewById(R.id.listView1);
		arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1);
		for(int i=0; i<100; i++)
		{
			arrayAdapter.add("JJ Item "+i);
		}
		listView.setAdapter(arrayAdapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				TextView textView = (TextView)getActivity().findViewById(R.id.textView1);
				textView.setText(arrayAdapter.getItem(arg2).toString());
			}
		});
		
		return view;
	} 

}
