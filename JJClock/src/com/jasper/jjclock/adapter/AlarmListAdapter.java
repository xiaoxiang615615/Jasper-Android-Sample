package com.jasper.jjclock.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fortysevendeg.swipelistview.SwipeListView;
import com.jasper.jjclock.R;

public class AlarmListAdapter<T> extends BaseAdapter {

	List<T> listData = new ArrayList<T>();
	Context context;
	
	public AlarmListAdapter(Context context){
		this.context = context;
	}
	
	
	public void add(T element){
		listData.add(element);
		notifyDataSetChanged();
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listData.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return listData.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(final int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		View returnView;
		if(arg1 != null){
			returnView = arg1;
		}
		else{
			LayoutInflater inflater = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
			returnView = inflater.inflate(R.layout.alarm_cell, null);
		}
		TextView tvAlarm = (TextView) returnView.findViewById(R.id.tvAlarm);
		tvAlarm.setText(listData.get(arg0).toString());
		returnView.findViewById(R.id.btnDel).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg5) {
				// TODO Auto-generated method stub
				listData.remove(arg0);
				notifyDataSetChanged();
				
				SwipeListView layout = (SwipeListView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.lvAlarm);
				layout.closeAnimate(arg0);
			}
		});
		return returnView;
	}

}
