package bit.p042_layoutinflater;

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
	final String LT= "myLogs";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		LayoutInflater ltInflater = getLayoutInflater();
		
		LinearLayout linLay = (LinearLayout) findViewById (R.id.linLay);
		
		View view1 = ltInflater.inflate(R.layout.text, linLay, false);
		LayoutParams lp1 = view1.getLayoutParams();
		linLay.addView(view1);
		
		Log.d(LT,"Class of view1: " + view1.getClass().toString());
		Log.d(LT,"Class of LayoutParams of view1: " + lp1.getClass().toString());
		Log.d(LT,"Text view1: " + ((TextView) view1).getText());
		
		
		RelativeLayout relLay = (RelativeLayout) findViewById (R.id.relLay);
		View view2 = ltInflater.inflate(R.layout.text, relLay, true);
		LayoutParams lp2 = view2.getLayoutParams();
		
		Log.d(LT,"Class of view2: " + view2.getClass().toString());
		Log.d(LT,"Class of LayoutParams of view2: " + lp2.getClass().toString());
		Log.d(LT,"Text view2: " + ((TextView) view2).getText());		
	}

	
}
