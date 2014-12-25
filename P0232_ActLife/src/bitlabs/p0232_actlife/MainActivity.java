package bitlabs.p0232_actlife;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {
	
	final String TAG = "State";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Log.d(TAG, "onCreate()");        
        
    }
    
    protected void onStart(){
    	super.onStart();
    	Log.d(TAG, "onStart()");
    	
    }
    
    protected void onResume(){
    	super.onResume();
    	Log.d(TAG, "onResume()");
    	
    }
    
    protected void onPause(){
    	super.onPause();
    	Log.d(TAG,"onPause()");
    	
    }
    
    protected void onStop(){
    	super.onStop();
    	Log.d(TAG, "onStop()");
    	
    }
    
    protected void onDestropy(){
    	super.onDestroy();
    	Log.d(TAG, "onDestroy()");
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
}
