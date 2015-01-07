package bit.p_0271_getintentaction;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Info extends Activity {
	

	  protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.info);
	        
	        Intent intC = getIntent();
	        String act = intC.getAction();
	        
	        String format = "", textInfo = "";
	        
	        if (act.equals("IF.showtime")){
	        	format = "hh.mm.ss";
	        	textInfo = "TIME";
	        }
	        if (act.equals("IF.showdate")){
	        	format = "dd.M.yyyy";
	        	textInfo = "DATE";
	        }

	  SimpleDateFormat sdf = new SimpleDateFormat(format);
	  String datetime = sdf.format(new Date(System.currentTimeMillis()));
	  
	  TextView tvDate = (TextView) findViewById (R.id.tvDate);
	  tvDate.setText(textInfo + " " + datetime);
	  }
	  
}