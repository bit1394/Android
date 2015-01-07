package bit.p0281_extras;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewAct extends Activity {
	
	TextView tvView;

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewact);
        
        tvView = (TextView) findViewById (R.id.tvView);
        
        Intent intC = getIntent();
        
        String firstname = intC.getStringExtra("firstname");
        String lastname = intC.getStringExtra("lastname");
        
        tvView.setText("Your name is " + firstname + " " + lastname);
}
	}
