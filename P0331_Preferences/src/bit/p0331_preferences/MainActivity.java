package bit.p0331_preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	Button btnSave, btnLoad;
	EditText etText;
	SharedPreferences sPref;//объект хранящий данные
	
	final String SAVED_TEXT = "saved_text";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	btnSave = (Button)findViewById(R.id.btnSave);
	btnLoad = (Button)findViewById(R.id.btnLoad);
	etText = (EditText)findViewById(R.id.etText);
	
	btnSave.setOnClickListener(this);
	btnLoad.setOnClickListener(this);
	
	loadText(); //чтобы автоматом загружалось при открытии приложения
	}

	

	@Override
	public void onClick(View v) {
	switch(v.getId()){
	case R.id.btnSave:
		saveText();
		break;
	case R.id.btnLoad:
		loadText();
		break;
	default:
		break;
	
	
	}
	}
	
	void saveText(){ //сохранение данных
		sPref = getPreferences(MODE_PRIVATE);//режим доступа - только это приложение
		Editor ed = sPref.edit(); //Эдитор - позволяет редактировать данные
		ed.putString(SAVED_TEXT, etText.getText().toString()); //помещаем данные из Эдитора через поле ввода в хранилище
		ed.commit();//выполнение задуманного в предыдущей строке
		Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
	}
	
	void loadText(){
		sPref = getPreferences (MODE_PRIVATE);
		String store = sPref.getString(SAVED_TEXT, ""); //из хранилища sPref данные выгружаются в строку store
		etText.setText(store); //отображаем содержимое  store в поле ввода
		if (store != null){
			Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
		}
	}
	
protected void onDestroy(){ //чтобы автоматом сохранялось при выходе
	saveText();
	super.onDestroy();
}
}

