package bitlabs.p021_twoact;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TwoAct extends Activity implements OnClickListener{
	

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twoact);
        
        Button btnQuit = (Button) findViewById (R.id.btnQuit);

}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
		case R.id.btnQuit:
			finish();
		break;
		}
		// TODO Auto-generated method stub
		
	}
}