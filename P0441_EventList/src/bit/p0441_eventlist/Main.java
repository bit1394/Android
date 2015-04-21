package bit.p0441_eventlist;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main extends Activity {
	final String LT = "myLogs";
	ListView lvMain;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		lvMain = (ListView)findViewById (R.id.lvMain);
		
		ArrayAdapter<CharSequence> ad = ArrayAdapter.createFromResource (
				this, R.array.names, android.R.layout.simple_list_item_1);
		lvMain.setAdapter(ad);
		
		lvMain.setOnItemClickListener (new OnItemClickListener(){
			public void onItemClick (AdapterView<?> parent, View v, int position, long id){
			//	Log.d(LT, "ItemClick: position = " + position + ", id = " + id);
				
			}
		});
		
		lvMain.setOnItemSelectedListener (new OnItemSelectedListener() {
			public void onItemSelected (AdapterView<?> parent, View v, int position, long id){
			//	Log.d(LT, "ItemSelect: position = " + position + ", id = " + id);
			}
			public void onNothingSelected(AdapterView<?> parent){
				Log.d(LT, "ItemSelect: nothing");
			}
		});
		lvMain.setOnScrollListener (new OnScrollListener(){
			public void onScrollStateChanged (AbsListView view, int scrollState){
				Log.d(LT, "ScrollState = " + scrollState);
			}
			public void onScroll( AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount){
				Log.d(LT, "Scroll: FirstVisibleItem = " + firstVisibleItem
						+ ", VisibleItemCount = " + visibleItemCount
						+ ", TotalItemCount = " + totalItemCount);
			}
		});
		
	}

	
}
