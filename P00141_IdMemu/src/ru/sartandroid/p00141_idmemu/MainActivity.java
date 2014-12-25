package ru.sartandroid.p00141_idmemu;

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
		
		tv = (TextView) findViewById (R.id.textView);
		chb = (CheckBox) findViewById (R.id.chbExtMenu);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add (0, 1, 0, "add");
		menu.add (0, 2, 0, "edit");
		menu.add (0, 3, 3, "delete");
		menu.add (1, 4, 1, "copy");
		menu.add (1, 5, 2, "paste");
		menu.add (1, 6, 4, "exit");
	
		return super.onCreateOptionsMenu(menu);
	}
	
	public boolean onPrepareOptionsMenu (Menu menu) {
		
		menu.setGroupVisible (1, chb.isChecked());
		
		return super.onPrepareOptionsMenu(menu);
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Обработка нажатий пунктов меню
		
		StringBuilder sb = new StringBuilder ();
		
		//Выводим в TextView инфо о нажатой кнопке
		sb.append ("\r\n GROUP_ID: " + String.valueOf(item.getGroupId ()));
		sb.append ("\r\n ITEM_ID: " + String.valueOf(item.getItemId ()));
		sb.append ("\r\n ORDER: " + String.valueOf(item.getOrder ()));
		sb.append ("\r\n TITLE: " + String.valueOf(item.getTitle ()));
		
		tv.setText(sb.toString ());
				
		return super.onOptionsItemSelected(item);
	}
}
