package ru.s.p0191_simplecalc;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	EditText etNum1, etNum2;
	Button btnAdd, btnDec, btnMul, btnDiv;
	TextView tv;
	String oper;
	
	final int MENU_CLEAR_ID = 1;
	final int MENU_QUIT_ID = 2;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		etNum1 = (EditText) findViewById (R.id.etNum1);
		etNum2 = (EditText) findViewById (R.id.etNum2);
		
		btnAdd = (Button) findViewById (R.id.btnAdd);
		btnDec = (Button) findViewById (R.id.btnDec);
		btnMul = (Button) findViewById (R.id.btnMul);
		btnDiv = (Button) findViewById (R.id.btnDiv);
		
		tv = (TextView) findViewById (R.id.tv);
		
		btnAdd.setOnClickListener (this);
		btnDec.setOnClickListener (this);
		btnMul.setOnClickListener (this);
		btnDiv.setOnClickListener (this);
		
		
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
		switch (item.getItemId()) {
		case R.id.clear:
			etNum1.setText("");
			etNum2.setText("");
			tv.setText("");
			break;
		case R.id.quit:
			finish ();
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		float num1 = 0;
		float num2 = 0;
		float result = 0;
		
		//проверим поля на пустоту
		if (TextUtils.isEmpty(etNum1.getText().toString()) || TextUtils.isEmpty(etNum2.getText().toString())) {
			return;
		}
		//читаем поля и заполняем переменные
		num1 = Float.parseFloat (etNum1.getText().toString());
		num2 = Float.parseFloat (etNum2.getText().toString());
		
		//обрабатываем нажатие кнопок
		switch (arg0.getId()){
		
		case R.id.btnAdd:
			result = num1 + num2;
			oper = "+";
			break;
		case R.id.btnDec:
			result = num1 - num2;
			oper = "-";
			break;
		case R.id.btnMul:
			result = num1 * num2;
			oper = "*";
			break;
		case R.id.btnDiv:
			if (num2 == 0.0){
				Toast.makeText(this, "Division by Zero!", Toast.LENGTH_LONG).show();
				break;
			} else {			
			result = num1 / num2;
			oper = "/";
			break;
			}
		}
		if (num2 == 0){
			tv.setText("Error!");
		} else
		tv.setText(num1 + " " + oper + " " + num2 + " = " + result);
		
				
	}
}
