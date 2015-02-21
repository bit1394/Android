package bit.p0401_inflater;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main extends Activity {

	final String LT = "myLogs";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		LayoutInflater l_inflater = getLayoutInflater();
		LinearLayout l_layout = (LinearLayout) findViewById (R.id.l_layout);
		RelativeLayout r_layout = (RelativeLayout) findViewById (R.id.r_layout);
		
		View v1 = l_inflater.inflate(R.layout.text, l_layout, true);
		LayoutParams lp1 = v1.getLayoutParams();
		Log.d(LT, "Class of v1: " + v1.getClass().toString());
		Log.d(LT, "Class of LayoutParams 1: " + lp1.getClass().toString ());
		
		View v2 = l_inflater.inflate(R.layout.text, r_layout, true);
		LayoutParams lp2 = v2.getLayoutParams();		
		Log.d(LT, "Class of v2: " + v2.getClass().toString());
		Log.d(LT, "Class of LayoutParams 2: " + lp2.getClass().toString ());		
		
	}

	
}
