package bitlabs.p0232_actlife;



import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends Activity {
	
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


    
}
