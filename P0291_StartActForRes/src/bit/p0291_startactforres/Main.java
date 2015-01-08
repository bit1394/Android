package bit.p0291_startactforres;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class Main extends Activity implements OnClickListener{
	
	TextView tvName;
	Button btnInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        tvName = (TextView) findViewById (R.id.tvName);
        btnInput = (Button) findViewById (R.id.btnInput);
        
        btnInput.setOnClickListener(this);
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
		Intent intC = new Intent (this, NameAct.class);
		startActivityForResult (intC, 1);
		// TODO Auto-generated method stub
		
	}
	
	protected void onActivityResult (int requestCode, int resultCode, Intent data){
		if (data == null) {
			return;
		}
		
		String name = data.getStringExtra("name");
		tvName.setText("Name is " + name);
	}
}
