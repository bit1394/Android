package bit.p0421_listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main extends Activity {
	
	String[] names = {"Ann", "Bob", "Jane", "Hulk"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		ListView lvMain = (ListView) findViewById (R.id.lvMain);
		ArrayAdapter <String> adapter = new ArrayAdapter <String> (this, R.layout.mylist, names);
		lvMain.setAdapter (adapter);
		
	}

}
