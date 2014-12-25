package ru.startandroid.p0131_menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu men_u) {
		men_u.add ("MENU_1");
		men_u.add ("MENU_2");
		men_u.add ("MENU_3");
		men_u.add ("MENU_4");
		
		return super.onCreateOptionsMenu (men_u);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText (this, item.getTitle(), Toast.LENGTH_SHORT).show ();
		
		return super.onOptionsItemSelected(item);
	}
}
