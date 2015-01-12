package bit.p031_onactresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AlignAct extends Activity implements OnClickListener {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		
		Button btnLeft, btnCenter, btnRight;
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.align);
        
        btnLeft = (Button) findViewById (R.id.btnLeft);
        btnCenter = (Button) findViewById (R.id.btnCenter);
        btnRight = (Button) findViewById (R.id.btnRight);
        
        btnLeft.setOnClickListener(this);
        btnCenter.setOnClickListener(this);
        btnRight.setOnClickListener (this);
        
    }

	@Override
	public void onClick(View v) {
		Intent intent = new Intent ();
		
		switch (v.getId ()){
		case R.id.btnLeft:
			intent.putExtra("alignment", Gravity.LEFT);
			break;
		case R.id.btnCenter:
			intent.putExtra("alignment", Gravity.CENTER);
			break;
		case R.id.btnRight:
			intent.putExtra ("alignment", Gravity.RIGHT);
			break;
		}
		setResult (RESULT_OK, intent);
		finish ();
	}

}
