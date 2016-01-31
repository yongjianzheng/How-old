package com.app.howold;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.app.howold.lib.RiseNumberTextView;

public class ShowActivity extends Activity {

	private Button again;
	private RiseNumberTextView dayView;
	private TextView zhushiView;
	private RiseNumberTextView yearView;
	private ProgressBar progressBar;
	private RiseNumberTextView minuteView;
	private RiseNumberTextView hourView;
	private RiseNumberTextView secondView;
	private int iCount = 0;
	
	protected static final int STOP = 0x10000;  
	protected static final int NEXT = 0x10001;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.show_result);
		again = (Button) findViewById(R.id.again);
		progressBar =(ProgressBar) findViewById(R.id.progressBar);
		dayView = (RiseNumberTextView) findViewById(R.id.show);
		zhushiView = (TextView) findViewById(R.id.zhushi);
		yearView = (RiseNumberTextView) findViewById(R.id.show_age);
		secondView= (RiseNumberTextView) findViewById(R.id.show_second);
		minuteView = (RiseNumberTextView) findViewById(R.id.show_minute);
		hourView= (RiseNumberTextView) findViewById(R.id.show_hour);
		int day= getIntent().getIntExtra("day", 0);
		double year = getIntent().getDoubleExtra("year", 0);
		int hour = getIntent().getIntExtra("hour", 0);
		int minute = getIntent().getIntExtra("minute", 0);
		int second = getIntent().getIntExtra("second", 0);
		
		dayView.withNumber(day);
		dayView.setDuration(3000);
		dayView.start();
		
	    final int ayear = (int) year;
		//progressBar.setProgress(ayear);
		zhushiView.setText("You have lived for "+day+" days!");
		
		String yString = String.valueOf(year);
		float f = Float.valueOf(yString);
		yearView.withNumber(f);
		yearView.setDuration(3000);
		yearView.start();

		secondView.withNumber(second);
		secondView.setDuration(3000);
		secondView.start();
		
		minuteView.withNumber(minute);
		minuteView.setDuration(3000);
		minuteView.start();
		
		hourView.withNumber(hour);
		hourView.setDuration(3000);
		hourView.start();
		
		again.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ShowActivity.this,ChooseActivity.class);
				startActivity(intent);
				ShowActivity.this.finish();
			}
		});
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (iCount>=60)
				{
					for (int i = 0; i < ayear; i++) {	
						try {
							iCount = i+1;
							progressBar.setProgress(iCount);
							Thread.sleep(40);

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
					}
				}else if (iCount>30&&iCount<60) {
					for (int i = 0; i < ayear; i++) {	
						try {
							iCount = i+1;
							progressBar.setProgress(iCount);
							Thread.sleep(80);

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  
				}
				}else if (iCount<30) {
					for (int i = 0; i < ayear; i++) {	
						try {
							iCount = i+1;
							progressBar.setProgress(iCount);
							Thread.sleep(160);

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  
					}
				}
			}
		}).start();
		}

}
