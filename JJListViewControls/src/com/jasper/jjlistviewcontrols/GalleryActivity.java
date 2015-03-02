package com.jasper.jjlistviewcontrols;

import android.R.array;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Gallery;

public class GalleryActivity extends Activity {
	
	Gallery gallery;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery_layout);
		gallery = (Gallery)findViewById(R.id.gallery1);
		
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(GalleryActivity.this, android.R.layout.simple_list_item_1);
		for(int i=0; i<100; i++)
		{
			arrayAdapter.add("Item"+i);
		}
		gallery.setAdapter(arrayAdapter);
	}
}
