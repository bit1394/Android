package bitlabs.p021_simpleanim;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class MainActivity extends Activity {
	 
	final int ALPHA = 1;
	final int ROTATE = 2;
	final int TRANS = 3;
	final int COMBO = 4;
	final int SCALE = 5;
	
	TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        tv = (TextView) findViewById (R.id.tv);
        
        registerForContextMenu(tv);
        
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        
    	switch (v.getId()){
    	case R.id.tv:
    		menu.add(0, ALPHA, 0, "alpha");
    		menu.add(0, SCALE, 0, "scale");
    		menu.add(0, ROTATE, 0, "rotate");
    		menu.add(0, TRANS, 0, "translate");
    		menu.add(0, COMBO, 0, "combo");
    		break;
    	}
    	super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
    
    	Animation anim = null;
    	
    	switch (item.getItemId()){
    	case ALPHA:
    		anim = AnimationUtils.loadAnimation(this, R.anim.myalpha);
    		break;
    	case COMBO:
    		anim = AnimationUtils.loadAnimation(this, R.anim.mycombo);
    		break;
    	case TRANS:
    		anim = AnimationUtils.loadAnimation(this, R.anim.mytrans);
    		break;
    	case ROTATE:
    		anim = AnimationUtils.loadAnimation(this, R.anim.myrotate);
    		break;
    	case SCALE:
    		anim = AnimationUtils.loadAnimation(this, R.anim.myscale);
    		break;
    }
    	tv.startAnimation(anim);
    	
        return super.onOptionsItemSelected(item);
    }
}
