package ru.startandroid.p0152_contextmenuxml;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	final int Red = 1;
	final int Blue = 2;
	final int S22 = 3;
	final int S30 = 4;
	
	TextView tvC, tvS;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		tvC = (TextView) findViewById (R.id.tvC);
		tvS = (TextView) findViewById (R.id.tvS);
	
		registerForContextMenu (tvC);
		registerForContextMenu (tvS);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {

		
		switch (v.getId ()){
	
		case R.id.tvC:
			menu.add (0, Red, 0, "RED" );
			menu.add (0, Blue, 0, "BLUE");
			break;
		
		case R.id.tvS:
			menu.add (0, S22, 0, "Size to 22");
			menu.add (0, S30, 0, "Size to 30");
			break;
		
		}
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		switch (item.getItemId ()) {
		
		case Red:
			tvC.setTextColor(Color.RED);
			tvC.setText("RED");
			break;
			
		case Blue:
			tvC.setTextColor(Color.BLUE);
			tvC.setText("BLUE");
			break;	
			
		case S22:
			tvS.setTextSize(22);
			tvS.setText("Size is 22");
			break;
			
		case S30:
			tvS.setTextSize(30);
			tvS.setText("Size is 30");
			break;
		}
		
		return super.onContextItemSelected(item);
	}
}
