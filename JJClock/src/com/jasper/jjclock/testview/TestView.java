package com.jasper.jjclock.testview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost;

import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;
import com.jasper.jjclock.R;
import com.jasper.jjclock.adapter.AlarmCellData;
import com.jasper.jjclock.adapter.AlarmListArrayAdapter;

public class TestView extends Activity {
	
	SwipeListView swipelistview;
	ItemAdapter adapter;
	List<ItemRow> itemData;
	TabHost host;
	AlarmListArrayAdapter alarmAdapter;
	List<AlarmCellData> alarmsData;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_listview);
        host = (TabHost) findViewById(R.id.jjtabhost);
        host.setup();
        host.addTab(host.newTabSpec("Tab1").setContent(R.id.tabJJ1).setIndicator("Tab1"));
		host.addTab(host.newTabSpec("Tab2").setContent(R.id.tabJJ2).setIndicator("Tab2"));
		host.addTab(host.newTabSpec("Tab3").setContent(R.id.tabJJ3).setIndicator("Tab3"));
		
		
        swipelistview=(SwipeListView)findViewById(R.id.lvAlarm); 
//        itemData=new ArrayList<ItemRow>();
//        adapter=new ItemAdapter(this,R.layout.test_listcell,itemData);
        alarmsData = new ArrayList<AlarmCellData>();
        alarmAdapter = new AlarmListArrayAdapter(this,R.layout.alarm_cell,alarmsData);
        
     
        
        swipelistview.setSwipeListViewListener(new BaseSwipeListViewListener() {
            @Override
            public void onOpened(int position, boolean toRight) {
            }

            @Override
            public void onClosed(int position, boolean fromRight) {
            }

            @Override
            public void onListChanged() {
            }

            @Override
            public void onMove(int position, float x) {
            }

            @Override
            public void onStartOpen(int position, int action, boolean right) {
                Log.d("swipe", String.format("onStartOpen %d - action %d", position, action));
            }

            @Override
            public void onStartClose(int position, boolean right) {
                Log.d("swipe", String.format("onStartClose %d", position));
            }

            @Override
            public void onClickFrontView(int position) {
                Log.d("swipe", String.format("onClickFrontView %d", position));
                
             
//                swipelistview.openAnimate(position); //when you touch front view it will open
              
             
            }

            @Override
            public void onClickBackView(int position) {
                Log.d("swipe", String.format("onClickBackView %d", position));
                
//                swipelistview.closeAnimate(position);//when you touch back view it will close
            }

            @Override
            public void onDismiss(int[] reverseSortedPositions) {
            	
            }

        });
        
        //These are the swipe listview settings. you can change these
        //setting as your requirement 
//        swipelistview.setSwipeMode(SwipeListView.SWIPE_MODE_BOTH); // there are five swiping modes
//        swipelistview.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_DISMISS); //there are four swipe actions 
//        swipelistview.setSwipeActionRight(SwipeListView.SWIPE_ACTION_REVEAL);
//        swipelistview.setOffsetLeft(convertDpToPixel(0f)); // left side offset
//        swipelistview.setOffsetRight(convertDpToPixel(80f)); // right side offset
//        swipelistview.setAnimationTime(500); // Animation time
//        swipelistview.setSwipeOpenOnLongPress(true); // enable or disable SwipeOpenOnLongPress
	
        swipelistview.setAdapter(alarmAdapter);
        
        
//        for(int i=0;i<10;i++)
//        {
//        	itemData.add(new ItemRow("Swipe Item"+i,getResources().getDrawable(R.drawable.ic_launcher) ));
//        	
//        }
        
        for(int i=0;i<10;i++)
        {
        	alarmsData.add(new AlarmCellData("123123123"));
        	
        }
        
        alarmAdapter.notifyDataSetChanged();
        
//        findViewById(R.id.btnAdd).setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				itemData.add(new ItemRow("Swipe Item"+100,getResources().getDrawable(R.drawable.ic_launcher) ));
//				adapter.notifyDataSetChanged();
//			}
//		});
    }

    public int convertDpToPixel(float dp) {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return (int) px;
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//	private void initAlarmList(){
//		Button btnAdd = (Button) findViewById(R.id.btnAdd);
//		final SwipeListView lvAlarm = (SwipeListView) findViewById(R.id.lvAlarm);
//		final AlarmListAdapter<AlarmCell> adapter = new AlarmListAdapter<AlarmCell>(TestView.this);
//		
//		lvAlarm.setAdapter(adapter);
//		
//		btnAdd.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				Calendar calendar = Calendar.getInstance();
//				int hour = calendar.get(Calendar.HOUR_OF_DAY);
//				int minute = calendar.get(Calendar.MINUTE);
//				
//				TimePickerDialog pickerDialog = new TimePickerDialog(TestView.this, new OnTimeSetListener() {
//
//					@Override
//					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//						// TODO Auto-generated method stub
//						if (view.isShown()) {
//							AlarmCell alarmCell = new AlarmCell();
//							alarmCell.setAlarmTime(String.valueOf(String.format("%02d",hourOfDay))+" : "+String.valueOf(String.format("%02d",minute)));
//							adapter.add(alarmCell);
//						}
//					};
//				}, hour, minute, true);
//				pickerDialog.show();
//				
//			}
//		});
//		
//		lvAlarm.setSwipeListViewListener(new SwipeListViewListener() {
//			
//			@Override
//			public void onStartOpen(int position, int action, boolean right) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onStartClose(int position, boolean right) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onOpened(int position, boolean toRight) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onMove(int position, float x) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onListChanged() {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onLastListItem() {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onFirstListItem() {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onDismiss(int[] reverseSortedPositions) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onClosed(int position, boolean fromRight) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onClickFrontView(int position) {
//				// TODO Auto-generated method stub
////				lvAlarm.openAnimate(position);
//			}
//			
//			@Override
//			public void onClickBackView(int position) {
//				// TODO Auto-generated method stub
////				lvAlarm.closeAnimate(position);
//			}
//			
//			@Override
//			public void onChoiceStarted() {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onChoiceEnded() {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onChoiceChanged(int position, boolean selected) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public int onChangeSwipeMode(int position) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		});
//		
//	
//		
//
//	}
}
