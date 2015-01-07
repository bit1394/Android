package bitlabs.p0261_intentfilter;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DateShow extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dshow);
        
        SimpleDateFormat sdf = new SimpleDateFormat ("dd:MMM:yyyy");
        String date = sdf.format (new Date(System.currentTimeMillis()));
        TextView tvDate = (TextView) findViewById (R.id.tvDate); 
        tvDate.setText(date);
        

}

}
