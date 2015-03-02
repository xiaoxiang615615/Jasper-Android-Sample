package com.jasper.jjsqllite;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jasper.models.user;

public class JJListViewAdaper extends BaseAdapter {

	Context context;
	
	List<user> users = new ArrayList<user>();
	
	public JJListViewAdaper(Context context)
	{
		this.context = context;
	}
	
	public void add(user user)
	{
		users.add(user);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return users.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return users.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		LinearLayout ll;
		if (convertView!=null) {
			ll = (LinearLayout) convertView;
		}else{
			ll = (LinearLayout)((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.jj_listcell, null);
		}
		TextView tv1 = (TextView)ll.findViewById(R.id.name);
		user user = (user)getItem(arg0);
		tv1.setText(user.getName());
		TextView tv2 = (TextView)ll.findViewById(R.id.gender);
		tv2.setText(user.getGender());
		return ll;
	}

}
