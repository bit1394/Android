package bit.p0311_intentdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.net.Uri;


public class Main extends Activity implements OnClickListener{

	Button btnWeb, btnGeo, btnTel;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    btnWeb = (Button) findViewById(R.id.btnWeb);
    btnGeo = (Button) findViewById (R.id.btnGeo);
    btnTel = (Button) findViewById(R.id.btnTel);
    
    btnWeb.setOnClickListener(this);
    btnGeo.setOnClickListener(this);
    btnTel.setOnClickListener(this);
        
    }
   
	@Override
	public void onClick(View arg0) {
		Intent intc;
		
		switch (arg0.getId()){
		
		case R.id.btnWeb:
			intc = new Intent (Intent.ACTION_VIEW, Uri.parse("http://google.com"));
			startActivity (intc);
			break;
			
		case R.id.btnGeo:
			intc = new Intent ();
			intc.setAction(Intent.ACTION_VIEW);
			intc.setData (Uri.parse("geo:0, 0"));
			startActivity (intc);
			break;
			
		case R.id.btnTel:
			intc = new Intent (Intent.ACTION_VIEW);
			intc.setData(Uri.parse("tel:+79279812340"));
			startActivity(intc);
			break;
			
		}
		
	}
}
