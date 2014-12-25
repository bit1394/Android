package ru.s.p0181_dynlayout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity implements OnSeekBarChangeListener  {
	
	SeekBar sb;
	Button btn1, btn2;
	
	LinearLayout.LayoutParams lp1, lp2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		sb = (SeekBar) findViewById (R.id.sb);
		btn1 = (Button) findViewById (R.id.btn1);
		btn2 = (Button) findViewById (R.id.btn2);
		
		lp1 = (LinearLayout.LayoutParams) btn1.getLayoutParams ();
		lp2 = (LinearLayout.LayoutParams) btn2.getLayoutParams ();                      
		
		sb.setOnSeekBarChangeListener (this);
	}

	

	@Override
	public void onProgressChanged(SeekBar sb, int progress, boolean fromUser) {
		// TODO Auto-generated method stub
		int leftVal = progress;
		int rightVal = sb.getMax () - progress;
		//настраиваем вес кнопок - установка веса в реальном времени
		
		lp1.weight = leftVal;
		lp2.weight = rightVal;
		
		//отобразим вес (прогресс с сик-бара) на кнопках
		
		btn1.setText(String.valueOf(leftVal));
		btn2.setText(String.valueOf(rightVal));
		
		
				
	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
}
