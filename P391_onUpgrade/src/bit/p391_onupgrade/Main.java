package bit.p391_onupgrade;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

public class Main extends Activity {
	final String LT = "myLogs";
	final String DB_NAME = "staff";
	final int DB_VERSION = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		DBHelper dbh = new DBHelper (this);
		SQLiteDatabase db = dbh.getWritableDatabase();
		Log.d(LT,"---Staff db v." + db.getVersion() + "---");
		writeStaff(db);
		dbh.close();
	} 

	//запрос данных и вывод в лог
	private void writeStaff(SQLiteDatabase db) {
		Cursor c = db.rawQuery("select * from people", null);
		logCursor(c, "Table people");
		c.close();
	}
	//вывод в лог данных из курсора
	void logCursor (Cursor c, String title){
		if (c != null){
			if (c.moveToFirst()){
				Log.d(LT, title + "." + c.getCount() + "rows");
				StringBuilder sb = new StringBuilder ();
				do {
					sb.setLength(0);
					for (String cn : c.getColumnNames()) {
						sb.append (cn + "=" + c.getString(c.getColumnIndex(cn)) + ";");
					}
 				Log.d(LT, sb.toString());				
				} while (c.moveToNext());
			}
			} else Log.d(LT, title + ". Cursor id null");
		}
// класс для работы с БД
	class DBHelper extends SQLiteOpenHelper {

	public DBHelper(Context context){
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d(LT, "---Creating database---");
		String [] people_name = {"Иван","Петр", "Сидор", "Антон"};
		String [] people_positions = {"Бухгалтер","Директор","Бухгалтер","Программист"};
		ContentValues cv = new ContentValues ();
		//создаем таблицу людей
		db.execSQL("create table people ("
				+ "id integer primary key autoincrement,"
				+ "name text,"
				+ "position text);");
		
		//заполним БД людей
		for (int i = 0; i < people_name.length; i++){
		cv.clear();
		cv.put("name", people_name [i]);
		cv.put("position", people_positions [i]);
		db.insert("people", null, cv);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
  }
}
