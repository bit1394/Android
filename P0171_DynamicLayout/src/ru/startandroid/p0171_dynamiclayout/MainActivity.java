package ru.startandroid.p0171_dynamiclayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	LinearLayout llMain;
	RadioGroup rgGravity;
	Button bCreate, bClear;
	EditText etName;
	
	int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		llMain = (LinearLayout) findViewById (R.id.llMain);
		rgGravity = (RadioGroup) findViewById (R.id.rgGravity);
		bCreate = (Button) findViewById (R.id.bCreate);
		bClear = (Button) findViewById (R.id.bClear);
		etName = (EditText)findViewById (R.id.etName);
		
		bCreate.setOnClickListener(this);
		bClear.setOnClickListener(this);	
		
	} 


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId ()) {
		case R.id.bCreate:
			//создаем LayoutParams с размерами wrap_content
			LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams (
					wrapContent, wrapContent);
			//Создаем гравитацию (по умолчанию ВЛЕВО) - в переменную.
			int bGravity = Gravity.LEFT;
			//определяем где стоит чек в радио-кнопке
			
			switch (rgGravity.getCheckedRadioButtonId ()) {
			case R.id.rbLeft:
				bGravity = Gravity.LEFT;
				break;
			case R.id.rbRight:
				bGravity = Gravity.RIGHT;
				break;
			case R.id.rbCenter:
				bGravity = Gravity.CENTER;
				break;
			}
		//перенесем полученное значение в LayoutParams  - наш lParams:
			lParams.gravity = bGravity;
		
		//создаем кнопку, пишем на ней текст и запихиваем в LinearLayout с именем  llMain
			Button bMain = new Button (this);
			bMain.setText(etName.getText().toString ());
			llMain.addView(bMain, lParams);
			break;
		case R.id.bClear:
			llMain.removeAllViews ();
			Toast.makeText(this, "CLEARED", Toast.LENGTH_SHORT).show ();
				
			}
			
	
		
	}
}
