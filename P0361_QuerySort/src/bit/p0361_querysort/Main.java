package bit.p0361_querysort;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Main extends Activity implements OnClickListener{
	
	final String LOG_TAG = "myLogs";
	String name[] = {"Китай","США","Бразилия", "Россия","Япония","Германия","Египет","Италия","Франция","Канада"};
	int people[] = {1400,311,195,142,128,82,80,60,66,35};
	String region[] = {"Азия", "Америка","Америка","Европа","Азия","Европа","Африка","Европа","Европа","Америка"};
	
	Button btnAll, btnPeople, btnFunc, btnGroup, btnHaving, btnSort;
	RadioGroup rgSort;
	EditText etFunc, etPeople, etRegionPeople;
	
	DBHepler dbHelper;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		findViewById(R.id.btnAll).setOnClickListener(this);
		findViewById(R.id.btnFunc).setOnClickListener(this);
		findViewById(R.id.btnPeople).setOnClickListener(this);
		findViewById(R.id.btnGroup).setOnClickListener(this);
		findViewById(R.id.btnHaving).setOnClickListener(this);
		findViewById(R.id.btnSort).setOnClickListener(this);
		
		rgSort = (RadioGroup) findViewById (R.id.rgSort);
		
		etFunc = (EditText) findViewById (R.id.etFunc);
		etPeople = (EditText) findViewById (R.id.etPeople);
		etRegionPeople = (EditText) findViewById (R.id.etRegionPeople);
		
		dbHelper = new DBHelper(this);
		//подключение к ДБ
		db = dbHelper.getWritableDatabaase();
		//проверим существование записей
		
		Cursor c = db.query("mytable", null, null, null, null, null, null);
		if (c.getCount() == 0){
			ContentValues cv = new ContentValues();
			//заполним таблицу
			for (int i = 0; i < 10; i++){
				cv.put("name", name[i]);
				cv.put("people", people[i]);
				cv.put("region", region[i]);
				Log.d(LOG_TAG, "id=" + db.insert("mytable", null, cv));
			}
		}
		c.close();
		dbHelper.close();
	//эмулируем нажатие кнопки ПОКАЗАТЬ ВСЁ
		onClick (btnAll);
		
	}
	public void onCli
		
		
	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
