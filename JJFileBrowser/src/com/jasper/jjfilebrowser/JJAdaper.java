package com.jasper.jjfilebrowser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class JJAdaper extends BaseAdapter {

	private List<File> files = new ArrayList<File>();
	private Context context;

	public JJAdaper(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public void add(File file)
	{
		files.add(file);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return files.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return files.get(arg0);
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
			arg1 = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.jj_listview_item, null);
		}
		ImageView imageviewJJ = (ImageView)arg1.findViewById(R.id.imageviewJJ);
		if(files.get(arg0).isDirectory())
		{
			imageviewJJ.setImageResource(com.jasper.jjfilebrowser.R.drawable.foldericon);
		}
		else{
			imageviewJJ.setImageResource(R.drawable.fileicon);
		}
		TextView textviewJJ = (TextView)arg1.findViewById(R.id.textviewJJ);
		textviewJJ.setText(files.get(arg0).getName());
		return arg1;
	}

}
