package ru.startandroid.p0091_onclickbuttons;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tvOut;
	Button btnOk;
	Button btnCancel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		tvOut = (TextView) findViewById (R.id.tvOut);
		btnOk = (Button) findViewById (R.id.btnOk);
		btnCancel = (Button) findViewById (R.id.btnCancel);
		
		OnClickListener oclBtnOk = new OnClickListener (){
			public void onClick (View v){
				tvOut.setText("OK button was pressed");
			}
		};
		
		btnOk.setOnClickListener (oclBtnOk);
		
		OnClickListener oclBtnCancel = new OnClickListener (){
			public void onClick (View v){
				tvOut.setText("Cancel button was pressed");
			}
		};
		
		btnCancel.setOnClickListener (oclBtnCancel);
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
