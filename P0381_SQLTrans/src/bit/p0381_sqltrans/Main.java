package bit.p0381_sqltrans;

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
	
	DBHelper dbh;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Log.d(LT, "---onCreateActiviy---");
		dbh = new DBHelper(this);
		myActions();
	}

	void myActions(){
		db =  dbh.getWritableDatabase();
		delete(db,"mytable");
		
		db.beginTransaction();
		insert(db,"mytable","val1");
		insert(db,"mytable","val2");
		insert(db, "mytable","val3");
		db.setTransactionSuccessful();
		db.endTransaction();
		
		read(db,"mytable");
		dbh.close();
	}
	
	void insert (SQLiteDatabase db, String table, String value){
		Log.d(LT, "Insert intable " + table + " value = " + value);
		ContentValues cv = new ContentValues ();
		cv.put("val", value);
		db.insert(table, null, cv);
	}
	
	void read(SQLiteDatabase db, String table){
		Log.d(LT, "Read table " + table);
		Cursor c = db.query(table, null,null,null,null,null,null);
		if (c != null){
			Log.d(LT, "Records count = " + c.getCount());
			if (c.moveToFirst()){
				do {
					Log.d(LT, c.getString(c.getColumnIndex("val")));
				} while (c.moveToNext());
				}
			c.close();
			}
		}
	
	void delete (SQLiteDatabase db, String table){
		Log.d(LT, "Delete from table " + table);
		db.delete (table, null, null);
	}
	
	//класс для работы с БД
	class DBHelper extends SQLiteOpenHelper {
		public DBHelper (Context context){
			super (context, "myDB", null, 1);
		}
	public void onCreate (SQLiteDatabase db){
		Log.d(LT, "---Creating database---");
		
		db.execSQL("create table mytable ("
				+ "id integer primary key autoincrement,"
				+ "val text"
				+ ");");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}		
  }
}

