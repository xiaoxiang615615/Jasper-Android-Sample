package com.jasper.jjlistviewcontrols;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class ImageSwitcherActivity extends Activity {
	
	ImageSwitcher imageSwitcher; 
	Boolean imageSwitch;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_switcher);
		imageSwitch = true;
		imageSwitcher = (ImageSwitcher)findViewById(R.id.imageSwitcher1);
		imageSwitcher.setFactory(new ViewFactory() {
			
			@Override
			public View makeView() {
				// TODO Auto-generated method stub
				return new ImageView(ImageSwitcherActivity.this);
			}
		});
		
		
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(ImageSwitcherActivity.this, android.R.anim.fade_in));
		imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(ImageSwitcherActivity.this, android.R.anim.fade_out));
		
		imageSwitcher.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				imageSwitch = !imageSwitch;
				setImage();
			}
		});
		
		setImage();
	}
	
	private void setImage()
	{
		if(imageSwitch)
		{
			imageSwitcher.setImageResource(R.drawable.img1);
		}
		else
		{
			imageSwitcher.setImageResource(R.drawable.img2);
		}
	}
}
