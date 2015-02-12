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
	final int DB_VERSION = 2;

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

	//������ ������ � ����� � ���
	private void writeStaff(SQLiteDatabase db) {
		Cursor c = db.rawQuery("select * from people", null);
		logCursor(c, "Table people");
		c.close();
		
		c = db.rawQuery("select * from position", null);
		logCursor(c, "Table position");
		c.close();
		
		String sqlQuery = "select PL.name as Name, PS.name as Position, salary as Salary"
		+ " from people as PL"
		+ " inner join position as PS"
		+ " on PL.posid = PS.id";
		c = db.rawQuery(sqlQuery, null);
		logCursor(c, "inner join");
		c.close();
	}
	
	//����� � ��� ������ �� �������
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
// ����� ��� ������ � ��
	class DBHelper extends SQLiteOpenHelper {

	public DBHelper(Context context){
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d(LT, "---Creating database---");
		//������ ��� ������� ����� (�����)
		String [] people_name = {"����","����", "�����", "�����"};
		int [] people_posid = {1,2,1,3};
		//������ ��� ������� ���������� 
		int [] position_id = {1,2,3};
		String [] position_name = {"���������","��������","�����������"};
		int [] position_salary = {10000, 15000, 13000};
		
		ContentValues cv = new ContentValues ();
		
		//������� ������� �����
		db.execSQL("create table people ("
				+ "id integer primary key autoincrement,"
				+ "name text,"
				+ "posid integer);");
		
		//�������� �� �����
		for (int i = 0; i < people_name.length; i++){
		cv.clear();
		cv.put("name", people_name [i]);
		cv.put("posid", people_posid [i]);
		db.insert("people", null, cv);
		}
		
		//������� ������� ����������
		db.execSQL("create table position ("
				+ "id integer primary key,"
				+ "name text,"
				+ "salary integer);");
		//�������� ������� ����������
		for (int i = 0; i < position_id.length; i++){
			cv.clear();
			cv.put("id", position_id[i]);
			cv.put("name", position_name [i]);
			cv.put("salary", position_salary [i]);
			db.insert("position", null, cv);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.d(LT,"---onUpgrade database from " + oldVersion + " to " + newVersion + " version---");
		if (oldVersion == 1 & newVersion == 2){
			ContentValues cv = new ContentValues ();
			
			//������ ��� ������� ����������
			int [] position_id = {1,2,3};
			String [] position_name = {"���������","��������","�����������"};
			int [] position_salary = {10000,15000,13000};
			
			db.beginTransaction();
			try{
				///������� ������� ����������
				db.execSQL("create table position ("
						+ "id integer primary key,"
						+ "name text,"
						+ "salary integer);");
				//�������� ������� ����������
				for (int i = 0; i < position_id.length; i++){
					cv.clear();
					cv.put("id", position_id[i]);
					cv.put("name", position_name [i]);
					cv.put("salary", position_salary [i]);
					db.insert("position", null, cv);
				}			
			//���������� ������� posid  � ������� �����
			db.execSQL("alter table people add column posid integer");
			for (int i = 0; i < position_id.length; i++){
				cv.clear();
				cv.put("posid", position_id [i]);
				db.update("people", cv, "position = ?", new String [] {position_name [i]});
			}
			//������� ��������� �������
			db.execSQL("create temporary table people_tmp ("
					+ "id integer, name text, position text, posid integer);");
			//��������� ������ �� ������� ����� �� ���������
			db.execSQL("insert into people_tmp select id, name, position, posid from people;");
			//������� �������� ������� �����
			db.execSQL("drop table people;");
			//������� ����� ������� �����
			db.execSQL("create table people ("
					+ "id integer primary key autoincrement,"
					+ "name text,"
					+ "posid integer);");
			//��������� ������ �� ��������� ������� � ����� ������� �����
			db.execSQL("insert into people select id, name, posid from people_tmp");
			//������� ��������� �������
			db.execSQL("drop table people_tmp");
			db.setTransactionSuccessful();
			}finally{
	  db.endTransaction();
			}
		}
	}
		}
}