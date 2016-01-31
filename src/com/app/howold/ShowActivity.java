package com.app.howold;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class ShowActivity extends Activity {

	private Button again;
	private TextView dayView;
	private TextView zhushiView;
	private TextView yearView;
	private TextView secondView;
	private TextView minuteView;
	private TextView hourView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.show_result);
		again = (Button) findViewById(R.id.again);
		dayView = (TextView) findViewById(R.id.show);
		zhushiView = (TextView) findViewById(R.id.zhushi);
		yearView = (TextView) findViewById(R.id.show_age);
		secondView= (TextView) findViewById(R.id.show_second);
		minuteView = (TextView) findViewById(R.id.show_minute);
		hourView= (TextView) findViewById(R.id.show_hour);
		int day= getIntent().getIntExtra("day", 0);
		double year = getIntent().getDoubleExtra("year", 0);
		int hour = getIntent().getIntExtra("hour", 0);
		int minute = getIntent().getIntExtra("minute", 0);
		int second = getIntent().getIntExtra("second", 0);
		dayView.setText(day+"");
		zhushiView.setText("You have lived for "+day+" days!");
		yearView.setText(year+"");
		secondView.setText(second+"");
		minuteView.setText(minute+"");
		hourView.setText(hour+"");
		again.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ShowActivity.this,ChooseActivity.class);
				startActivity(intent);
				ShowActivity.this.finish();
			}
		});
		
	}
}
