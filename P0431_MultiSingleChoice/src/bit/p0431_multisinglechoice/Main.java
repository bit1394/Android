package bit.p0431_multisinglechoice;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Main extends Activity implements OnClickListener{
	final String LT = "myLogs"; 
	ListView lvMain;
	String names [];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		lvMain = (ListView) findViewById (R.id.lvMain);
		lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		ArrayAdapter <CharSequence> ad = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_list_item_multiple_choice);
		lvMain.setAdapter(ad);
		
		Button btnGet = (Button) findViewById (R.id.btnGet);
		btnGet.setOnClickListener(this);
		
		names = getResources().getStringArray(R.array.names);
	}

	@Override
	public void onClick(View v) {
		Log.d(LT, "Checked: ");
		SparseBooleanArray sbArray = lvMain.getCheckedItemPositions();//создаем объект - он хранит инфо о нажатии
		for (int i = 0; i < sbArray.size(); ++i){ //считываем все возможные нажатия = числу элементов
			int key = sbArray.keyAt(i); //собственно позиция элемента - ключ
			if (sbArray.get(key)) // значение - был ли нажат элемент
				Log.d(LT, names[key]); // выводим имя элемента с номером key (ключ)
		}
		
	}

	
}
