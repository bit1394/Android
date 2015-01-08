package bit.p0291_startactforres;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NameAct extends Activity implements OnClickListener{
	

	EditText etName;
	Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name);
        
        etName = (EditText) findViewById (R.id.etName);
        btnOk = (Button) findViewById (R.id.btnOk);
        
        btnOk.setOnClickListener(this);

}

	@Override
	public void onClick(View v) {
		Intent intC = new Intent ();
		intC.putExtra("name", etName.getText().toString());
		setResult(RESULT_OK, intC);
		finish();
	}
}