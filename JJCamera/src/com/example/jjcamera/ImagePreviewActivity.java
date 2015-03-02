package com.example.jjcamera;

import java.io.File;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class ImagePreviewActivity extends Activity{

	ImageView imageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_preview);
		imageView = (ImageView)findViewById(R.id.imageView);
		String imagePath = getIntent().getStringExtra("path");
		if(imagePath != null)
		{
			imageView.setImageURI(Uri.fromFile(new File(imagePath)));
		}
	}

}
