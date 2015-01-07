package bitlabs.p0261_intentfilter;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Main extends Activity implements OnClickListener{
	
	Button btnTime, btnDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btnTime = (Button) findViewById (R.id.btnTime);
        btnDate = (Button) findViewById (R.id.btnDate);
        
        btnTime.setOnClickListener(this);
    	btnDate.setOnClickListener(this);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onClick(View arg0) {
		Intent intCal;
		
		switch (arg0.getId()){
		
		case R.id.btnTime:
			intCal = new Intent ("IntentFilter.showtime");
			startActivity(intCal);
			break;
		case R.id.btnDate:
			intCal = new Intent ("IntentFilter.showdate");
			startActivity(intCal);
			break;
			
		}
	//	
		
		
		// TODO Auto-generated method stub
		
	}
}
