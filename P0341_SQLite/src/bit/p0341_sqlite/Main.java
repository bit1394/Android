package bit.p0341_sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Main extends Activity implements OnClickListener{
	
	final String LOG_TAG = "myLogs";

	Button btnAdd, btnRead, btnClear;
	EditText etName, etEmail;
	
	DBHelper dbHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	
		btnAdd = (Button) findViewById (R.id.btnAdd);
		btnRead = (Button)findViewById (R.id.btnRead);
		btnClear = (Button) findViewById(R.id.btnClear);
		
		etName = (EditText) findViewById (R.id.etName);
		etEmail = (EditText) findViewById(R.id.etEmail);
		
		btnAdd.setOnClickListener (this);
		btnRead.setOnClickListener (this);
		btnClear.setOnClickListener (this);
		
		dbHelper = new DBHelper(this);	
	}

	@Override
	public void onClick(View v) {
		//создадим объект для данных
		ContentValues cv = new ContentValues();
		
		//получаем данные из EditText
		String name = etName.getText().toString();
		String email = etEmail.getText().toString();
		
		//подключаемся к БД
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		
		switch (v.getId()){
		case R.id.btnAdd:
			Log.d(LOG_TAG, "---Insert in mytable:---");
			//подготовка данных для вставки в виде пары "название поля - значение"
			cv.put("name", name);
			cv.put("email", email);
			//вставляем запись и получаем ее ID
			long  rowID = db.insert("mytable", null, cv);
			Log.d(LOG_TAG,"row inserted, ID = " + rowID);
			break;
			
		case R.id.btnRead:
			Log.d(LOG_TAG, "---Row in mytable:---");
			//делаем запрос на выборку из таблицы mytable, получим объект типа Cursor
			Cursor c = db.query("mytable", null, null, null, null, null, null);
			//ставим курсор на 1-ю строку. если строк в выборке нет вернется false
			if (c.moveToFirst()){
				int idColIndex = c.getColumnIndex("id");
				int nameColIndex = c.getColumnIndex("name");
				int emailColIndex = c.getColumnIndex("email");
				
				do{
					//получим значения по номерам столбцов и загоним их в лог
					Log.d(LOG_TAG,
							"ID = " + c.getInt(idColIndex) +
							", name = " + c.getString(nameColIndex) +
							", email = " + c.getString(emailColIndex));
				} while (c.moveToNext());
			}
			else
				Log.d(LOG_TAG, "0 rows");
			c.close();
			break;
			
		case R.id.btnClear:
			Log.d(LOG_TAG, "---Clear mytable:---");
			//удалим все записи, delete выдает кол-во удаленных записей
			int clearCount = db.delete("mytable", null, null);
			Log.d(LOG_TAG, "deleted rows count = " + clearCount);
			break;
		}
		//закроем подключение к БД
		dbHelper.close();
	}
			
	class DBHelper extends SQLiteOpenHelper {
		
		public DBHelper (Context context){
			//вызываем конструктор суперкласса - создание БД с именем myDBB
			super(context, "myDBB", null, 1);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			Log.d(LOG_TAG, "---onCreate database:---");
			//создаем таблицу с полями
			db.execSQL("create table mytable ("
					+ "id integer primary key autoincrement,"
					+ "name text,"
					+ "email text" + ");");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {						
		}
	}

	
	
}
