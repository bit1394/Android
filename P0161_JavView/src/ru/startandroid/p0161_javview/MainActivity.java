package ru.startandroid.p0161_javview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout ll = new LinearLayout (this);
		ll.setOrientation(LinearLayout.VERTICAL);
		
		LayoutParams paramMatch = new LayoutParams (LayoutParams.MATCH_PARENT, 
				LayoutParams.MATCH_PARENT);
		setContentView(ll, paramMatch);
		
		LayoutParams paramWrap = new LayoutParams (LayoutParams.WRAP_CONTENT, 
				LayoutParams.WRAP_CONTENT);
		
		TextView tv = new TextView (this);
		tv.setText("TV");
		tv.setLayoutParams(paramWrap);
		ll.addView(tv);
		
		Button btn = new Button (this);
		btn.setText("Baton");
		ll.addView(btn, paramMatch);
		
		LinearLayout.LayoutParams paramLeftMarg = new LinearLayout.LayoutParams 
				(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		paramLeftMarg.leftMargin = 50;
		Button btn1 = new Button (this);
		btn1.setText("Margin 50");
		ll.addView(btn1, paramLeftMarg);
		
		LinearLayout.LayoutParams paramRGrav = new LinearLayout.LayoutParams 
				(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		paramRGrav.gravity = Gravity.RIGHT;
		Button btn2 = new Button (this);
		btn2.setText("Right grav");
		ll.addView(btn2, paramRGrav);
		}
}
