package com.app.howold;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;

public class ChooseActivity extends Activity {
	
	private Button okbtn;
	private DatePicker picker;
	private int nowYear;
	private int nowMonth;
	private int nowDay;
	private int yourYear;
	private int yourMonth;
	private int yourDay;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.choose);
		okbtn = (Button) findViewById(R.id.btn);
		picker = (DatePicker) findViewById(R.id.time);
		Calendar calendar = Calendar.getInstance();
		nowYear=calendar.get(Calendar.YEAR);
		nowMonth= calendar.get(Calendar.MONTH);
		nowDay =  calendar.get(Calendar.DAY_OF_MONTH);
		yourYear=calendar.get(Calendar.YEAR);
		yourMonth= calendar.get(Calendar.MONTH);
		yourDay =  calendar.get(Calendar.DAY_OF_MONTH);
		picker.init(nowYear,nowMonth,nowDay, new DatePicker.OnDateChangedListener() {
			
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				// TODO Auto-generated method stub
				yourYear = year;
				yourMonth = monthOfYear;
				yourDay = dayOfMonth;
			}
		});
		okbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date d1 = dFormat.parse(nowYear+"-"+nowMonth+"-"+nowDay);
					Date d2 = dFormat.parse(yourYear+"-"+yourMonth+"-"+yourDay);
					long diff = d1.getTime()-d2.getTime();
					
					int aSecond=  (int) (diff/1000);
					int aMinute = aSecond/60;
					int aHour = aMinute/60;
					int aDay =aHour/24;
					double aYear = diff/365.0/3600/24/1000;
					Intent i = new Intent(ChooseActivity.this,ShowActivity.class);
					i.putExtra("day", aDay);
					i.putExtra("year", aYear);
					i.putExtra("hour",aHour);
					i.putExtra("minute", aMinute);
					i.putExtra("second", aSecond);
					startActivity(i);
					ChooseActivity.this.finish();
					overridePendingTransition(R.anim.showin, R.anim.chooseout);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
}
}
