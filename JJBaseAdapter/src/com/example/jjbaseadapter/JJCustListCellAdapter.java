package com.example.jjbaseadapter;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class JJCustListCellAdapter<T> extends BaseAdapter {

	private List<T> list = new ArrayList<>();
	
	private Context context;
	private int resId;
	
	public JJCustListCellAdapter(Context context, int resId)
	{
		this.context = context;
		this.resId = resId;
	}
	
	
	
	public Context getContext() {
		return context;
	}



	public void setContext(Context context) {
		this.context = context;
	}



	public int getResId() {
		return resId;
	}



	public void setResId(int resId) {
		this.resId = resId;
	}

	public void add(T object)
	{
		list.add(object);
		notifyDataSetChanged();
	}
	
	public void remove(int position)
	{
		list.remove(position);
	}
	
	public void removeLast()
	{
		list.remove(getCount() -1);
		notifyDataSetChanged();
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		
		if(arg1 == null)
		{
			arg1 = LayoutInflater.from(this.context).inflate(resId, null);
		}

		initView(arg0, arg1, arg2);
		return arg1;
	}
	
	public abstract void initView(int arg0, View arg1, ViewGroup arg2);

}
