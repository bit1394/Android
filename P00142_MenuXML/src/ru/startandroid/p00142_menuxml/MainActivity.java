package ru.startandroid.p00142_menuxml;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView tv;
	CheckBox chb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		tv = (TextView) findViewById (R.id.tv);
		chb = (CheckBox) findViewById (R.id.chb);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mymenu, menu);
		return super.onCreateOptionsMenu(menu);
		
	}
	
	public boolean onPrepareOptionsMenu (Menu menu){
		
		menu.setGroupVisible(R.id.g1, chb.isChecked());
		
	return super.onPrepareOptionsMenu (menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	
		StringBuilder sb = new StringBuilder ();
		
		sb.append("MENU:");
		sb.append ("\r\n GROUP: " + String.valueOf(item.getGroupId ()));
		sb.append ("\r\n ITEM: " + String.valueOf(item.getItemId ()));
		sb.append ("\r\n ORDER: " + String.valueOf (item.getOrder()));
		sb.append ("\r\n TITLE: " + String.valueOf(item.getTitle ()));
		
		tv.setText(sb.toString ());
		
		return super.onOptionsItemSelected(item);
	}
}
