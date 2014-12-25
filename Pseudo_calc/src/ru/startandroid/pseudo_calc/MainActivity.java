package ru.startandroid.pseudo_calc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	TextView tv;
	Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn;
	String mem;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		tv = (TextView) findViewById (R.id.tv);
		btn1 = (Button) findViewById (R.id.btn1);
		btn2 = (Button) findViewById (R.id.btn2);
		btn3 = (Button) findViewById (R.id.btn3);
		btn4 = (Button) findViewById (R.id.btn4);
		btn5 = (Button) findViewById (R.id.btn5);
		btn6 = (Button) findViewById (R.id.btn6);
		btn7 = (Button) findViewById (R.id.btn7);
		btn8 = (Button) findViewById (R.id.btn8);
		btn9 = (Button) findViewById (R.id.btn9);
		btn = (Button) findViewById (R.id.btn);
		
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		btn9.setOnClickListener(this);
		btn.setOnClickListener(this);
		
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

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			tv.setText ("1");
			mem = "1";
			break;
		case R.id.btn2:
			tv.setText ("2");
			mem = "2";
			break;
		case R.id.btn3:
			tv.setText ("3");
			mem = "3";
			break;
		case R.id.btn4:
			tv.setText ("4");
			mem = "4";
			break;
		case R.id.btn5:
			tv.setText ("5");
			mem = "5";
			break;
		case R.id.btn6:
			tv.setText ("6");
			mem = "6";
			break;
		case R.id.btn7:
			tv.setText ("7");
			mem = "7";
			break;
		case R.id.btn8:
			tv.setText ("8");
			mem = "8";
			break;
		case R.id.btn9:
			tv.setText ("9");
			mem = "9";
			break;
		case R.id.btn:
			btn.setText(mem);
			break;
			
		}
		
		
	}
}
