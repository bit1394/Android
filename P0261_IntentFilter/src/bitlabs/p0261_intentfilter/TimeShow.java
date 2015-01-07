package bitlabs.p0261_intentfilter;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TimeShow extends Activity {
	

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tshow);
        
        SimpleDateFormat sdf = new SimpleDateFormat ("HH:mm:ss");
        String time = sdf.format (new Date(System.currentTimeMillis()));
        TextView tvTime = (TextView) findViewById (R.id.tvTime); 
        tvTime.setText(time);
        

}
}