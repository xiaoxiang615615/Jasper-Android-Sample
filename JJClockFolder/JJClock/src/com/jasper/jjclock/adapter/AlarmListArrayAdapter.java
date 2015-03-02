package com.jasper.jjclock.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jasper.jjclock.R;

public class AlarmListArrayAdapter extends ArrayAdapter<AlarmCellData> {

	List<AlarmCellData>   data; 
	Context context;
	int layoutResID;
	
	

	public AlarmListArrayAdapter(Context context, int layoutResourceId,List<AlarmCellData> data) {
		super(context, layoutResourceId, data);

		this.data=data;
		this.context=context;
		this.layoutResID=layoutResourceId;

		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		CellHolder holder = null;
		View row = convertView;
		holder = null;

		if(row == null)
		{
			LayoutInflater inflater = ((Activity)context).getLayoutInflater();
			row = inflater.inflate(layoutResID, parent, false);

			holder = new CellHolder();

			holder.tvAlarm = (TextView)row.findViewById(R.id.tvAlarm);
			holder.btnDel=(Button)row.findViewById(R.id.btnDel);
			
			row.setTag(holder);
		}
		else
		{
			holder = (CellHolder)row.getTag();
		}


		AlarmCellData itemdata = data.get(position);
		holder.tvAlarm.setText(itemdata.getAlarmTime());
		

		holder.btnDel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "Btn Del Clicked",Toast.LENGTH_SHORT).show();
			}
		});


		return row;

	}


	static class CellHolder{

		TextView tvAlarm;
		ImageView icon;
		Button btnDel;

	}


}
