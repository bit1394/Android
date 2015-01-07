package bit.p0281_extras;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class Main extends Activity implements OnClickListener{
	EditText etFName, etLName;
	Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        etFName = (EditText) findViewById (R.id.etFName);
        etLName = (EditText) findViewById (R.id.etLName);
        btn = (Button) findViewById (R.id.btn);
        
        btn.setOnClickListener(this);
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
	public void onClick(View v) {
		Intent intC = new Intent (this, ViewAct.class);
		
		intC.putExtra("firstname", etFName.getText().toString());
		intC.putExtra("lastname", etLName.getText().toString());
		
		startActivity(intC);
		
		
		// TODO Auto-generated method stub
		
	}
}
