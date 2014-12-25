package ru.startandroid.p0161_javview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout llout = new LinearLayout (this);
		llout.setOrientation(LinearLayout.VERTICAL);
		
		LayoutParams lloutParam = new LayoutParams (LayoutParams.MATCH_PARENT, 
				LayoutParams.MATCH_PARENT);
		setContentView(llout, lloutParam);
		
		LayoutParams lpView = new LayoutParams (LayoutParams.WRAP_CONTENT, 
				LayoutParams.WRAP_CONTENT);
		
		TextView tv = new TextView (this);
		tv.setText("TV");
		tv.setLayoutParams(lpView);
		llout.addView(tv);
		
		Button btn = new Button (this);
		btn.setText("Baton");
		llout.addView(btn, lpView);
		
		LinearLayout.LayoutParams leftMarginParams = new LinearLayout.LayoutParams 
				(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		leftMarginParams.leftMargin = 50;
		Button btn1 = new Button (this);
		btn1.setText("Margin 50");
		llout.addView(btn1, leftMarginParams);
		
		LinearLayout.LayoutParams rGravityParams = new LinearLayout.LayoutParams 
				(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		rGravityParams.gravity = Gravity.RIGHT;
		Button btn2 = new Button (this);
		btn2.setText("Right grav");
		llout.addView(btn2, rGravityParams);
		
				
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
